package com.ctest.core.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.ctest.core.repository.BaseCarCustomRepository;
import com.ctest.models.BaseCar;
import com.ctest.models.query.SellableQuery;
import com.ctest.utils.CommonQueryUtils;

@Repository
public class BaseCarCustomRepositoryImpl implements BaseCarCustomRepository {
	@PersistenceContext
	protected EntityManager em;

	@Override
	public List<BaseCar> list(SellableQuery queryParams) {
		return CommonQueryUtils.generateSellableQuery(this.em, queryParams, BaseCar.class).getResultList();
	}
}
