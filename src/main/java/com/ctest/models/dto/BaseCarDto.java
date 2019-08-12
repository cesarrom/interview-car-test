package com.ctest.models.dto;

import java.io.Serializable;

import org.springframework.beans.BeanUtils;

import com.ctest.models.BaseCar;

//@Builder
public class BaseCarDto extends CommonModelDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;

	private Double price;

	private String name;

	public BaseCarDto() {
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
	
	public BaseCar getCrudModel() {
		BaseCar res = new BaseCar();
		BeanUtils.copyProperties(this, res);
		return res;
	}
}