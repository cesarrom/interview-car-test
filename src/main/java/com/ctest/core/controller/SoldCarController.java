package com.ctest.core.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ctest.core.business.SoldCarBusiness;
import com.ctest.helpers.ResponseCanonical;
import com.ctest.models.dto.BaseCarDto;
import com.ctest.models.dto.SoldCarDto;
import com.ctest.models.query.SellableQuery;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "Sold Cars Management Operations")
@RequestMapping("/api/v1/sold-cars")
public class SoldCarController {
	private SoldCarBusiness business;

	@Autowired
	public SoldCarController(SoldCarBusiness business) {
		this.business = business;
	}

	@ApiOperation(value = "List sold cars", response = List.class)
	@GetMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseCanonical<List<SoldCarDto>> list(SellableQuery query) {
		return new ResponseCanonical<>(this.business.list(query));
	}

	@ApiOperation(value = "find a specific sold car with its options", response = BaseCarDto.class)
	@GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseCanonical<SoldCarDto> find(@PathVariable Long id) {
		return new ResponseCanonical<>(this.business.find(id));
	}

	@ApiOperation(value = "sells a car with existing options", response = BaseCarDto.class)
	@PostMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseCanonical<SoldCarDto> create(@Valid @RequestBody SoldCarDto params) {
		return new ResponseCanonical<>(this.business.create(params));
	}

	@ApiOperation(value = "estimates a car's price with existing options", response = BaseCarDto.class)
	@PostMapping(path = "/estimate", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseCanonical<SoldCarDto> estimate(@Valid @RequestBody SoldCarDto params) {
		return new ResponseCanonical<>(this.business.estimate(params.getCarId(), params.getCarOptionIds(), null));
	}

	@ApiOperation(value = "updates a sold car with any existing option", response = BaseCarDto.class)
	@PutMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseCanonical<SoldCarDto> update(@PathVariable Long id, @RequestBody SoldCarDto params) {
		return new ResponseCanonical<>(this.business.update(id, params));
	}

}
