package com.skm.recipeapp.repositories;

import com.skm.recipeapp.domain.UnitOfMeasure;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UnitOfMeasureRepository extends CrudRepository<com.skm.recipeapp.domain.UnitOfMeasure,Long> {
    Optional<UnitOfMeasure> findByDescription(String description);
}
