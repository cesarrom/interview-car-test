package com.ctest.core.business;

import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ctest.models.dto.BaseCarDto;
import com.ctest.models.query.SellableQuery;
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { RuntimeException.class })
public interface BaseCarBusiness {
	@Transactional(propagation = Propagation.REQUIRED)
	public BaseCarDto create(BaseCarDto car);
	@Transactional(propagation = Propagation.REQUIRED)
	public BaseCarDto update(Long id, BaseCarDto car);
	public List<BaseCarDto> list(SellableQuery query);
	public BaseCarDto find(Long id);
}
