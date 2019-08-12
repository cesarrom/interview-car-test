package com.ctest.core.business.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ctest.core.business.BaseCarBusiness;
import com.ctest.core.dao.BaseCarDao;
import com.ctest.helpers.exceptions.NotFoundException;
import com.ctest.models.BaseCar;
import com.ctest.models.dto.BaseCarDto;
import com.ctest.models.query.SellableQuery;

@Service
public class BaseCarBusinessImpl implements BaseCarBusiness {
	private BaseCarDao baseCarDao;

	@Autowired
	public BaseCarBusinessImpl(BaseCarDao baseCarDao) {
		this.baseCarDao = baseCarDao;
	}

	@Override
	public BaseCarDto create(BaseCarDto car) {
		BaseCar dbCar = car.getCrudModel();
		this.baseCarDao.save(dbCar);
		return dbCar.getDtoModel();
	}

	@Override
	public BaseCarDto update(Long id, BaseCarDto car) {
		BaseCar dbCar = this.baseCarDao.findById(id).orElseThrow(() -> new NotFoundException(""));
		BeanUtils.copyProperties(car, dbCar);
		this.baseCarDao.update(dbCar);
		return dbCar.getDtoModel();
	}

	@Override
	public List<BaseCarDto> list(SellableQuery query) {
		return this.baseCarDao.list(query).stream().map(value -> value.getDtoModel())
				.collect(Collectors.toList());
	}

	@Override
	public BaseCarDto find(Long id) {
		return this.baseCarDao.findById(id).orElseThrow(() -> new NotFoundException("")).getDtoModel();
	}

}
