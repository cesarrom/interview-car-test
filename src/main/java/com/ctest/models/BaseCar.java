package com.ctest.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.beans.BeanUtils;

import com.ctest.models.dto.BaseCarDto;

/**
 * The persistent class for the car database table.
 * 
 */
//@Builder
@Entity
@Table(name = "base_cars")
@NamedQuery(name = "BaseCar.findAll", query = "SELECT c FROM BaseCar c")
public class BaseCar extends CommonModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "BASECAR_ID_GENERATOR", sequenceName = "BASECAR_ID_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BASECAR_ID_GENERATOR")
	private Long id;
	
	private String name;

	private Double price;


	public BaseCar() {
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
	public BaseCarDto getDtoModel() {
		BaseCarDto res = new BaseCarDto();
		BeanUtils.copyProperties(this, res);
		return res;
	}

}