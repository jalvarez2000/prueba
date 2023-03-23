package com.example.prueba.dto;

import com.example.prueba.domain.product.ProductModel;
import lombok.Data;

import java.util.List;

@Data
public class ProductDTO {
    List<ProductModel> products;
}
