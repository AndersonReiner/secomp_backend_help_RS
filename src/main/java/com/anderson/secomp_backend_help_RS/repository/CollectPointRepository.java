package com.anderson.secomp_backend_help_RS.repository;

import com.anderson.secomp_backend_help_RS.model.CollectPoint;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CollectPointRepository extends JpaRepository<CollectPoint, Integer> {
    CollectPoint findByCollectPointId(Integer id);
}
