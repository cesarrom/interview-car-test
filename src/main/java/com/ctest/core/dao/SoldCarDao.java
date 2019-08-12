package com.ctest.core.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ctest.core.repository.BaseRepository;
import com.ctest.core.repository.SoldCarCustomRepository;
import com.ctest.models.SoldCar;

@Repository
public interface SoldCarDao extends JpaRepository<SoldCar, Long>, SoldCarCustomRepository, BaseRepository {
}
