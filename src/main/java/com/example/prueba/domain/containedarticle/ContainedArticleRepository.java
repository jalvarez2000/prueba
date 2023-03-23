package com.example.prueba.domain.containedarticle;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContainedArticleRepository extends CrudRepository<ContainedArticleModel, Integer> {

}
