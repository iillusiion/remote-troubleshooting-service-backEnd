package com.volunteer.web.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.volunteer.web.entity.TblDistribution;

public interface SaveDistribution extends CrudRepository<TblDistribution, Integer> {
	List<TblDistribution> findByIdNumber(String idNumber);
}
