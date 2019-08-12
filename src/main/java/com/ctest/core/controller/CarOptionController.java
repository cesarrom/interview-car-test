package com.ctest.core.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ctest.core.business.CarOptionBusiness;
import com.ctest.helpers.ResponseCanonical;
import com.ctest.models.dto.CarOptionDto;
import com.ctest.models.query.SellableQuery;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "Car Options Management Operations")
@RequestMapping("/api/v1/car-options")
public class CarOptionController {
	private CarOptionBusiness business;

	@Autowired
	public CarOptionController(CarOptionBusiness business) {
		this.business = business;
	}

	@ApiOperation(value = "List car options", response = List.class)
	@GetMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseCanonical<List<CarOptionDto>> list(SellableQuery query) {
		return new ResponseCanonical<>(this.business.list(query));
	}

	@ApiOperation(value = "find a specific option", response = CarOptionDto.class)
	@GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseCanonical<CarOptionDto> find(@PathVariable Long id) {
		return new ResponseCanonical<>(this.business.find(id));

	}

	@ApiOperation(value = "creates an option", response = CarOptionDto.class)
	@PostMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseCanonical<CarOptionDto> create(@RequestBody CarOptionDto params) {
		return new ResponseCanonical<>(this.business.create(params));
	}

	@ApiOperation(value = "updates an existing option", response = CarOptionDto.class)
	@PutMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseCanonical<CarOptionDto> update(@PathVariable Long id, @RequestBody CarOptionDto params) {
		return new ResponseCanonical<>(this.business.update(id, params));

	}
}
