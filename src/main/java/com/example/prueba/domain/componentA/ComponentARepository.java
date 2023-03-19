package com.example.prueba.domain.componentA;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComponentARepository extends CrudRepository<ComponentAModel, Integer>  {
   
}
