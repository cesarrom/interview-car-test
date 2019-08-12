package com.ctest.core.business;

import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ctest.models.SoldCar;
import com.ctest.models.dto.SoldCarDto;
import com.ctest.models.query.SellableQuery;
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { RuntimeException.class })
public interface SoldCarBusiness {
	@Transactional(propagation = Propagation.REQUIRED)
	public SoldCarDto create(SoldCarDto car);
	@Transactional(propagation = Propagation.REQUIRED)
	public SoldCarDto update(Long id, SoldCarDto car);
	public List<SoldCarDto> list(SellableQuery query);
	public SoldCarDto find(Long id);
	public SoldCarDto estimate(Long carId, List<Long> carOptionIds, SoldCar soldCar);
}
