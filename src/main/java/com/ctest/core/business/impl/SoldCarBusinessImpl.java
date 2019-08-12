package com.ctest.core.business.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ctest.core.business.SoldCarBusiness;
import com.ctest.core.dao.BaseCarDao;
import com.ctest.core.dao.CarOptionDao;
import com.ctest.core.dao.SoldCarDao;
import com.ctest.helpers.exceptions.BadRequestException;
import com.ctest.helpers.exceptions.NotFoundException;
import com.ctest.models.SoldCar;
import com.ctest.models.dto.SoldCarDto;
import com.ctest.models.query.SellableQuery;
import com.ctest.utils.ObjectUtils;

@Service
public class SoldCarBusinessImpl implements SoldCarBusiness {
	private SoldCarDao soldCarDao;
	private BaseCarDao baseCarDao;
	private CarOptionDao carOptionDao;

	@Autowired
	public SoldCarBusinessImpl(SoldCarDao soldCarDao, BaseCarDao baseCarDao, CarOptionDao carOptionDao) {
		this.soldCarDao = soldCarDao;
		this.baseCarDao = baseCarDao;
		this.carOptionDao = carOptionDao;
	}

	@Override
	public SoldCarDto create(SoldCarDto car) {
		SoldCar soldCar = this.estimateCRUD(car.getCarId(), car.getCarOptionIds(), null);
		this.soldCarDao.save(soldCar);
		return soldCar.getDtoModel();
	}

	@Override
	public SoldCarDto update(Long id, SoldCarDto car) {
		SoldCar soldCar = this.estimateCRUD(car.getCarId(), car.getCarOptionIds(),
				this.soldCarDao.findById(id).orElseThrow(() -> new NotFoundException("SOLD CAR NOT FOUND")));
		this.soldCarDao.update(soldCar);
		return soldCar.getDtoModel();
	}

	@Override
	public List<SoldCarDto> list(SellableQuery query) {
		return this.soldCarDao.list(query).stream().map(value -> value.getDtoModel()).collect(Collectors.toList());
	}

	@Override
	public SoldCarDto find(Long id) {
		return this.soldCarDao.findById(id).orElseThrow(() -> new NotFoundException("SOLD CAR NOT FOUND"))
				.getDtoModel();
	}

	@Override
	public SoldCarDto estimate(Long carId, List<Long> carOptionIds, SoldCar soldCar) {
		return this.estimateCRUD(carId, carOptionIds, soldCar).getDtoModel();
	}
	
	private SoldCar estimateCRUD(Long carId, List<Long> carOptionIds, SoldCar soldCar) {
		if (ObjectUtils.isFalsey(soldCar))
			soldCar = new SoldCar();
		soldCar.setCar(this.baseCarDao.findById(carId).orElseThrow(() -> new NotFoundException("CAR NOT FOUND")));
		soldCar.setCarOptions(this.carOptionDao.findAllById(carOptionIds).stream()
				.filter(value -> ObjectUtils.isThruthy(value)).collect(Collectors.toList()));
		if (ObjectUtils.isThruthy(soldCar.getCarOptions()) && soldCar.getCarOptions().size() != carOptionIds.size()) {
			throw new BadRequestException("SOME OF THE PROVIDED CAR OPTIONS WERE INVALID");
		}
		soldCar.setPrice(soldCar.getCar().getPrice() + soldCar.getCarOptions().stream().reduce(new Double(0.0),
				(accum, crrVal) -> accum + crrVal.getPrice(), Double::sum));
		return soldCar;
	}

}
