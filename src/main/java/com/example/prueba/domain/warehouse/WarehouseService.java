package com.example.prueba.domain.warehouse;

import com.example.prueba.algorithm.AvailableProductsGenerator;
import com.example.prueba.domain.article.ArticleModel;
import com.example.prueba.domain.article.ArticleService;
import com.example.prueba.domain.product.ProductModel;
import com.example.prueba.domain.product.ProductService;
import com.example.prueba.dto.InventoryDTO;
import com.example.prueba.dto.ProductAvailabilityDTO;
import com.example.prueba.dto.ProductDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@Slf4j
@Component
public class WarehouseService {
    private ArticleService articleService;
    private ProductService productService;
    
    public WarehouseService(ArticleService articleService, ProductService productService) {
        this.articleService = articleService;
        this.productService = productService;
    }
    
    public Iterable<ProductModel> getProducts() {
        return productService.getProducts();
    }
    
    public Iterable<ArticleModel> getArticles() {
        return articleService.getArticles();
    }
    
    @Transactional
    public Iterable<ProductAvailabilityDTO> getAvailableProducts() {
        Iterable<ProductModel> products =  productService.getProducts();
        Iterable<ArticleModel> articles = articleService.getArticles();
        
        return AvailableProductsGenerator.execute(products, articles);

    }
    
    @Transactional
    public void sellProduct(Integer id) {
        Iterable<ProductModel> products =  productService.getProducts();
        Iterable<ArticleModel> articles = articleService.getArticles();
        
        Iterable<ProductAvailabilityDTO> productsAvailabilityDTO =  AvailableProductsGenerator.execute(products, articles);
        ProductAvailabilityDTO productAvailabilityDTO = StreamSupport.stream(productsAvailabilityDTO.spliterator(),false).filter(product -> product.getProduct().getId().equals(id)).findFirst().get();    
        
        if (productAvailabilityDTO.getQuantity() < 1) {
            throw new RuntimeException("Product is not available");
        }

        productAvailabilityDTO.getProduct().getContainedArticles().forEach(containedArticle -> {
            ArticleModel articleModel = articleService.getArticle(containedArticle.getArtId()).get();
            articleModel.setStock(articleModel.getStock() - containedArticle.getAmountOf());
            articleService.saveArticle(articleModel);
        });
    }
    
    @PostConstruct
    private void init() {
        ObjectMapper mapper = new ObjectMapper();
        
        try {
            InventoryDTO inventoryDTO = mapper.readValue(getClass().getResourceAsStream("/defaultdata/inventory.json"), InventoryDTO.class);
            inventoryDTO.getInventory().forEach(article -> articleService.saveArticle(article));
            ProductDTO productDTO = mapper.readValue(getClass().getResourceAsStream("/defaultdata/products.json"), ProductDTO.class);
            productDTO.getProducts().forEach(product -> {
                productService.saveProduct(product);
            });
            
        } catch (UnrecognizedPropertyException e) {
            log.error("Error parsing inventory.json", e);
        } catch (IOException e) {
            log.error("Error reading inventory.json", e);
        }
    }
}
