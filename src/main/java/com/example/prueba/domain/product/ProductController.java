package com.example.prueba.domain.product;

import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {
   private ProductService productService;
    
    public ProductController(ProductService articuloService) {
        this.productService = articuloService;
    }

    @PostMapping("/product")
    private ProductModel saveArticle(@RequestBody ProductModel productModel) {
        productService.saveProduct(productModel);
        return productModel;
    }

    
    @GetMapping("/product/{id}")
    private ProductModel getArticle(@PathVariable Integer id) {
        return productService.getProduct(id).get();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/product")
    private Iterable<ProductModel> getArticles() {
        return productService.getProducts();
    }
}
