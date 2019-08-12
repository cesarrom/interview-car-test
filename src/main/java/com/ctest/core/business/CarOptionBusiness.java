package com.ctest.core.business;

import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ctest.models.dto.CarOptionDto;
import com.ctest.models.query.SellableQuery;
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { RuntimeException.class })
public interface CarOptionBusiness {
	@Transactional(propagation = Propagation.REQUIRED)
	public CarOptionDto create(CarOptionDto asset);
	@Transactional(propagation = Propagation.REQUIRED)
	public CarOptionDto update(Long id, CarOptionDto asset);
	public List<CarOptionDto> list(SellableQuery query);
	public CarOptionDto find(Long id);
}
