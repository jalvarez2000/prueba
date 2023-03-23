package com.example.prueba.domain.article;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends CrudRepository<ArticleModel, Integer>  {
   
}
