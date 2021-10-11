package com.mindtree.batsman.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.batsman.entity.Batsman;

@Repository
public interface BatsmanRepository extends JpaRepository<Batsman, Integer>{

}
