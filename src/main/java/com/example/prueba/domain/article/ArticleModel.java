package com.example.prueba.domain.article;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;

@Data
@Entity
public class ArticleModel {
    @Id
    @JsonProperty("art_id")
    private Integer artId;
    private String name;
    private Integer stock;
}
