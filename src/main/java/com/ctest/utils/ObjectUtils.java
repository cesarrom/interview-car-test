package com.ctest.utils;

import java.util.Collection;
import java.util.Map;

public class ObjectUtils {
	
	@SuppressWarnings("rawtypes")
	public static Boolean isThruthy(Object object) {
		Boolean response = true;
		if (object != null) {
			if (object instanceof Collection) {
				Collection collection = (Collection) object;
				response &= !collection.isEmpty();
			} else if (object instanceof Map) {
				Map map = (Map) object;
				response &= !map.isEmpty();
			} else if (object instanceof String) {
				String string = (String) object;
				response &= !string.isEmpty();
			} else if (object instanceof Boolean) {
				response = (Boolean) object;
			} else if (object instanceof Number) {
				response &= Double.parseDouble(object.toString()) != 0;
			} else if (object instanceof Iterable) {
				response &= ((Iterable) object).iterator().hasNext();
			}
		} else {
			response = false;
		}

		return response;
	}
	public static Boolean isAllThruthy(Object ...args) {
		Boolean response = true;
		response &= ObjectUtils.isThruthy(args);
		for(Object arg : args) {
			response &= ObjectUtils.isThruthy(arg);
		}
		return response;
	}
	public static Boolean isAllFalsey(Object ...args) {
		return !ObjectUtils.isAllThruthy(args);
	}
	public static Boolean isFalsey(Object object) {
		return !ObjectUtils.isThruthy(object);
	}
}
