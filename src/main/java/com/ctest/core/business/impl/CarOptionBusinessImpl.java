package com.ctest.core.business.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ctest.core.business.CarOptionBusiness;
import com.ctest.core.dao.CarOptionDao;
import com.ctest.helpers.exceptions.NotFoundException;
import com.ctest.models.CarOption;
import com.ctest.models.dto.CarOptionDto;
import com.ctest.models.query.SellableQuery;

@Service
public class CarOptionBusinessImpl implements CarOptionBusiness {
	private CarOptionDao carOptionDao;
	@Autowired
	public CarOptionBusinessImpl(CarOptionDao carOptionDao) {
		this.carOptionDao = carOptionDao;
	}
	
	@Override
	public CarOptionDto create(CarOptionDto carOption) {
		CarOption dbCar = carOption.getCrudModel();
		this.carOptionDao.save(dbCar);
		return dbCar.getDtoModel();
	}

	@Override
	public CarOptionDto update(Long id, CarOptionDto carOption) {
		CarOption dbCar = this.carOptionDao.findById(id).orElseThrow(() -> new NotFoundException(""));
		BeanUtils.copyProperties(carOption, dbCar);
		this.carOptionDao.update(dbCar);
		return dbCar.getDtoModel();
	}

	@Override
	public List<CarOptionDto> list(SellableQuery query) {
		return this.carOptionDao.list(query).stream().map(value -> value.getDtoModel())
				.collect(Collectors.toList());
	}

	@Override
	public CarOptionDto find(Long id) {
		return this.carOptionDao.findById(id).orElseThrow(() -> new NotFoundException("")).getDtoModel();
	}

}
