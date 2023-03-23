package com.example.prueba.domain.warehouse;

import com.example.prueba.domain.article.ArticleModel;
import com.example.prueba.domain.product.ProductModel;
import com.example.prueba.dto.ProductAvailabilityDTO;
import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.*;

@RestController
public class WarehouseController {
  private WarehouseService warehouseService;
  
  public WarehouseController(WarehouseService warehouseService) {
    this.warehouseService = warehouseService;
  }
  
  @CrossOrigin(origins = "http://localhost:4200")
  @GetMapping("/warehouse/products")
  private Iterable<ProductModel> getProducts() {
    return warehouseService.getProducts();
  }

  @CrossOrigin(origins = "http://localhost:4200")
  @GetMapping("/warehouse/articles")
  private Iterable<ArticleModel> getArticles() {
    return warehouseService.getArticles();
  }

  @CrossOrigin(origins = "http://localhost:4200")
  @GetMapping("/warehouse/availableProducts")
  private Iterable<ProductAvailabilityDTO> getAvailableProducts() {
    return warehouseService.getAvailableProducts() ;
  }

  @CrossOrigin(origins = "http://localhost:4200")
  @DeleteMapping("/warehouse/product/sell/{id}")
  private void sellProducts(@PathVariable Integer id) {
     warehouseService.sellProduct(id);
  }
}
