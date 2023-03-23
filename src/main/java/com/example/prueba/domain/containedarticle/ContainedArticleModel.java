package com.example.prueba.domain.containedarticle;

import com.example.prueba.domain.article.ArticleModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class ContainedArticleModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @JsonProperty("art_id")
    private Integer artId;
    @JsonProperty("amount_of")
    private Integer amountOf;
}
