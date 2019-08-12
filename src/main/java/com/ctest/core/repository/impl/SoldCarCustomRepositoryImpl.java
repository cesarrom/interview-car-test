package com.ctest.core.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.ctest.core.repository.SoldCarCustomRepository;
import com.ctest.models.SoldCar;
import com.ctest.models.query.SellableQuery;
import com.ctest.utils.CommonQueryUtils;

@Repository
public class SoldCarCustomRepositoryImpl implements SoldCarCustomRepository {
	@PersistenceContext
	protected EntityManager em;
	@Override
	public List<SoldCar> list(SellableQuery queryParams) {
		return CommonQueryUtils.generateSellableQuery(this.em, queryParams, SoldCar.class).getResultList();
	}
}
