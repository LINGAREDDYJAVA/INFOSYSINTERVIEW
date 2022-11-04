package com.test.management.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.management.beans.Cases;

@Repository
public interface CasesRepo extends JpaRepository<Cases,Integer> {
}
