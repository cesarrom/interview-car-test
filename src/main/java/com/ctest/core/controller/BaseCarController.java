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

import com.ctest.core.business.BaseCarBusiness;
import com.ctest.helpers.ResponseCanonical;
import com.ctest.models.dto.BaseCarDto;
import com.ctest.models.query.SellableQuery;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "Cars Management Operations")
@RequestMapping("/api/v1/cars")
public class BaseCarController {
	private BaseCarBusiness business;

	@Autowired
	public BaseCarController(BaseCarBusiness business) {
		this.business = business;
	}

	@ApiOperation(value = "List cars", response = List.class)
	@GetMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseCanonical<List<BaseCarDto>> list(SellableQuery query) {
		return new ResponseCanonical<>(this.business.list(query));
	}

	@ApiOperation(value = "find a specific car with its assets", response = BaseCarDto.class)
	@GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseCanonical<BaseCarDto> find(@PathVariable Long id) {
		return new ResponseCanonical<>(this.business.find(id));

	}

	@ApiOperation(value = "creates a car with any existing assets", response = BaseCarDto.class)
	@PostMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseCanonical<BaseCarDto> create(@RequestBody BaseCarDto params) {
		return new ResponseCanonical<>(this.business.create(params));
	}

	@ApiOperation(value = "updates a car with any existing assets", response = BaseCarDto.class)
	@PutMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseCanonical<BaseCarDto> update(@PathVariable Long id, @RequestBody BaseCarDto params) {
		return new ResponseCanonical<>(this.business.update(id, params));

	}
}
