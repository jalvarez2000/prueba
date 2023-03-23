package com.example.prueba.dto;

import com.example.prueba.domain.product.ProductModel;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductAvailabilityDTO {
  ProductModel product;
  Integer  quantity;
}
