package com.test.management.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.management.beans.Entities;

@Repository
public interface EntitiesRepo extends JpaRepository<Entities,Integer>{
}
