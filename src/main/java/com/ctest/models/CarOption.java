package com.ctest.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.beans.BeanUtils;

import com.ctest.models.dto.CarOptionDto;

/**
 * The persistent class for the car_asset database table.
 * 
 */
//@Builder
@Entity
@Table(name = "car_options")
@NamedQuery(name = "CarOption.findAll", query = "SELECT c FROM CarOption c")
public class CarOption extends CommonModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CAROPTION_ID_GENERATOR", sequenceName="CAROPTION_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CAROPTION_ID_GENERATOR")
	private Long id;

	private String name;

	private Double price;
	
	@Column(name="mnemonic")
	private String mnemonic;

	// bi-directional many-to-many association to Car
	@ManyToMany(mappedBy = "carOptions", fetch = FetchType.LAZY)
	private List<SoldCar> cars;

	public CarOption() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getMnemonic() {
		return mnemonic;
	}

	public void setMnemonic(String mnemonic) {
		this.mnemonic = mnemonic;
	}

	public List<SoldCar> getCars() {
		return this.cars;
	}

	public void setCars(List<SoldCar> cars) {
		this.cars = cars;
	}
	public CarOptionDto getDtoModel() {
		CarOptionDto res = new CarOptionDto();
		BeanUtils.copyProperties(this, res);
		return res;
	}

}