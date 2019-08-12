package com.ctest.core.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.ctest.core.repository.CarOptionCustomRepository;
import com.ctest.models.CarOption;
import com.ctest.models.query.SellableQuery;
import com.ctest.utils.CommonQueryUtils;

@Repository
public class CarOptionCustomRepositoryImpl implements CarOptionCustomRepository {
	@PersistenceContext
	protected EntityManager em;
	@Override
	public List<CarOption> list(SellableQuery queryParams) {
		return CommonQueryUtils.generateSellableQuery(this.em, queryParams, CarOption.class).getResultList();
	}
}
