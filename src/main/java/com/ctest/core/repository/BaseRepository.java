package com.ctest.core.repository;

import com.ctest.models.CommonModel;

public interface BaseRepository {
	
	public <T extends CommonModel> T create(T entity);
	
	public <T extends CommonModel> T createWithFlush(T t);
	
	public <T extends CommonModel> T update(T entity);
	
}
