package com.ctest.core.repository;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ctest.models.SoldCar;
import com.ctest.models.query.SellableQuery;

@Repository
@Transactional(readOnly = true)
public interface SoldCarCustomRepository {
	public List<SoldCar> list(SellableQuery query);
}
