package com.test.management.repo;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.management.beans.EntityToCases;



@Repository
public interface EntityToCasesRepo  extends JpaRepository<EntityToCases,Integer> {
}
