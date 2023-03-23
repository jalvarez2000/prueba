package com.example.prueba.dto;

import com.example.prueba.domain.article.ArticleModel;
import lombok.Data;

import java.util.List;

@Data
public class InventoryDTO {
    List<ArticleModel> inventory;
}
