package com.example.repo;

import com.example.entity.ServiceVisit;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitRepository extends CrudRepository<ServiceVisit, Integer> {
}
