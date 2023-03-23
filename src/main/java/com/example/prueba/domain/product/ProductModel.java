package com.example.prueba.domain.product;

import com.example.prueba.domain.article.ArticleModel;
import com.example.prueba.domain.containedarticle.ContainedArticleModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class ProductModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    @OneToMany(cascade = CascadeType.ALL)
    @JsonProperty("contain_articles")
    List<ContainedArticleModel> containedArticles;
}
