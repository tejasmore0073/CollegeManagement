package com.security.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.security.demo.model.Hod;

@Repository
public interface HodRepository extends JpaRepository<Hod, Integer> {

}
