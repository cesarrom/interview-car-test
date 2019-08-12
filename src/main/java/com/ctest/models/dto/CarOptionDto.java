package com.ctest.models.dto;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.ctest.models.CarOption;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * The persistent class for the categories database table.
 * 
 */

//@Builder
public class CarOptionDto extends CommonModelDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;

	private Double price;

	private String name;
	@JsonIgnore()
	private List<SoldCarDto> cars;


	public CarOptionDto() {
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

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public List<SoldCarDto> getCars() {
		return cars;
	}
	public void setCars(List<SoldCarDto> cars) {
		this.cars = cars;
	}
	public CarOption getCrudModel() {
		CarOption res = new CarOption();
		BeanUtils.copyProperties(this, res);

		return res;
	}
}