package com.mindtree.batsman.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mindtree.batsman.entity.Team;

public interface TeamRepository extends JpaRepository<Team, Integer>{

}
