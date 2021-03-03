package com.promineotech.fishingApi.repository;

import org.springframework.data.repository.CrudRepository;

import com.promineotech.fishingApi.entity.Results;

public interface ResultsRepositorty extends CrudRepository<Results, Long>{

	//Results findOne(long results_id);

}
