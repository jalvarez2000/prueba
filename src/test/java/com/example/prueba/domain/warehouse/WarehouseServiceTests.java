package com.example.prueba.domain.warehouse;

import com.example.prueba.domain.article.ArticleModel;
import com.example.prueba.domain.product.ProductModel;
import com.example.prueba.dto.ProductAvailabilityDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;


@SpringBootTest
public class WarehouseServiceTests {
  @Autowired
  WarehouseService warehouseService;
  
  @Test
  void availableProductTest() {
    Iterable< ProductAvailabilityDTO> availableProducts = this.warehouseService.getAvailableProducts(); 
    Collection<ProductAvailabilityDTO> availableProductsCollection = new ArrayList<>();
  }
}
