package com.ctest.core.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ctest.core.repository.BaseCarCustomRepository;
import com.ctest.core.repository.BaseRepository;
import com.ctest.models.BaseCar;

@Repository
public interface BaseCarDao extends BaseCarCustomRepository, JpaRepository<BaseCar, Long>, BaseRepository {
}
