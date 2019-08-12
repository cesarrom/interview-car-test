package com.ctest.core.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ctest.core.repository.BaseRepository;
import com.ctest.core.repository.CarOptionCustomRepository;
import com.ctest.models.CarOption;

@Repository
public interface CarOptionDao extends JpaRepository<CarOption, Long>, CarOptionCustomRepository, BaseRepository {
}
