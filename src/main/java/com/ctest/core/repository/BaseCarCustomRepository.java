package com.ctest.core.repository;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ctest.models.BaseCar;
import com.ctest.models.query.SellableQuery;

@Repository
@Transactional(readOnly = true)
public interface BaseCarCustomRepository {
	public List<BaseCar> list(SellableQuery query);
}
