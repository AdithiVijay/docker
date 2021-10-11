package com.mindtree.batsman.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.batsman.entity.Statistic;

@Repository
public interface StatisticRepository extends JpaRepository<Statistic, Integer>{

}
