package com.ctest.utils;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.ctest.models.query.SellableQuery;

public class CommonQueryUtils {
	public static<T> TypedQuery<T> generateSellableQuery(EntityManager em, SellableQuery queryParams, Class<T> clazz) {
		StringBuilder queryStr = new StringBuilder();
		Map<String, Object> nameValue = new HashMap<>();
		queryStr.append("SELECT bc FROM "+ clazz.getSimpleName() +" bc WHERE 1 = 1");
		if (ObjectUtils.isThruthy(queryParams.getFrom())) {
			queryStr.append(" AND bc.createdAt >= :fromParam ");
			nameValue.put("fromParam", queryParams.getFrom());
		}
		if (ObjectUtils.isThruthy(queryParams.getTo())) {
			queryStr.append(" AND bc.createdAt <= :toParam ");
			nameValue.put("toParam", queryParams.getTo());
		}
		if (ObjectUtils.isThruthy(queryParams.getFromPrice())) {
			queryStr.append(" AND bc.price >= :fromPrice ");
			nameValue.put("fromPrice", queryParams.getFromPrice());
		}
		if (ObjectUtils.isThruthy(queryParams.getToPrice())) {
			queryStr.append(" AND bc.price >= :toPrice ");
			nameValue.put("toPrice", queryParams.getToPrice());
		}
		if (ObjectUtils.isThruthy(queryParams.getName())) {
			queryStr.append(" AND bc.name LIKE :name ");
			nameValue.put("name", "%"+queryParams.getName()+"%");
		}
		if (ObjectUtils.isThruthy(queryParams.getMnemonic())) {
			queryStr.append(" AND bc.name LIKE :mnemonic ");
			nameValue.put("name", "%"+queryParams.getMnemonic()+"%");
		}
		TypedQuery<T> query = em.createQuery(queryStr.toString(), clazz);
		if (ObjectUtils.isThruthy(queryParams.getSkip())) {
			query.setFirstResult(queryParams.getSkip());
		}
		if (ObjectUtils.isThruthy(queryParams.getLimit())) {
			query.setMaxResults(queryParams.getLimit());
		}
		nameValue.forEach((key, value) -> query.setParameter(key, value));
		return query;
	};
}
