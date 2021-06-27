package com.training.trainingdealine.repository;

import com.training.trainingdealine.entity.HomeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HomeRepository extends JpaRepository<HomeEntity,Long> {


}
