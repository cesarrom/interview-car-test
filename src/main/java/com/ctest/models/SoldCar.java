package com.ctest.models;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.beans.BeanUtils;

import com.ctest.models.dto.BaseCarDto;
import com.ctest.models.dto.SoldCarDto;
import com.ctest.utils.ObjectUtils;

/**
 * The persistent class for the car database table.
 * 
 */
//@Builder
@Entity
@Table(name = "sold_cars")
@NamedQuery(name = "SoldCar.findAll", query = "SELECT c FROM SoldCar c")
public class SoldCar extends CommonModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "SOLDCAR_ID_GENERATOR", sequenceName = "SOLDCAR_ID_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SOLDCAR_ID_GENERATOR")
	private Long id;
	private String name;
	private BaseCar car;
	private Double price;

	// bi-directional many-to-many association to CarAsset
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "car_option_sold_car", joinColumns = @JoinColumn(name = "sold_car_id"), inverseJoinColumns = @JoinColumn(name = "car_option_id"))
	private List<CarOption> carOptions;

	public SoldCar() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BaseCar getCar() {
		return this.car;
	}

	public void setCar(BaseCar car) {
		this.car = car;
	}

	public List<CarOption> getCarOptions() {
		return this.carOptions;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCarOptions(List<CarOption> carOptions) {
		this.carOptions = carOptions;
	}
	public SoldCarDto getDtoModel() {
		SoldCarDto res = new SoldCarDto();
		BeanUtils.copyProperties(this, res);
		if(ObjectUtils.isThruthy(this.car)) {
			BaseCarDto soldCar = new BaseCarDto();
			soldCar.setName(this.car.getName());
			soldCar.setPrice(this.car.getPrice());
			soldCar.setCreatedAt(this.car.getCreatedAt());
			soldCar.setUpdatedAt(this.car.getUpdatedAt());
			soldCar.setId(this.car.getId());
			res.setCar(soldCar);
			res.setCarId(this.car.getId());
		}
		if (ObjectUtils.isThruthy(this.carOptions)) {
			res.setCarOptions(this.carOptions.stream().map((value) -> {
				return value.getDtoModel();
			}).collect(Collectors.toList()));
			res.setCarOptionIds(this.carOptions.stream().map((value) -> {
				return value.getId();
			}).collect(Collectors.toList()));
		}
		return res;
	}

}