package com.example.prueba.domain.product;

import com.example.prueba.domain.article.ArticleModel;
import com.example.prueba.domain.containedarticle.ContainedArticleRepository;
import com.example.prueba.dto.ProductAvailabilityDTO;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Component
public class ProductService {
    private ProductRepository productRepository;
    private ContainedArticleRepository  containedArticleRepository;
    
    public ProductService(ProductRepository productRepository, ContainedArticleRepository containedArticleRepository) { 
        this.productRepository = productRepository;
        this.containedArticleRepository = containedArticleRepository;
    }
    
    @Transactional
    public void saveProduct(ProductModel productModel) {
        productModel.getContainedArticles().forEach(containedArticle -> {
            containedArticleRepository.save(containedArticle);
        });
        productRepository.save(productModel);
    }
    
    @Transactional
    public Optional<ProductModel> getProduct(Integer id) {
        return productRepository.findById(id);
    }
    
    @Transactional
    public Iterable<ProductModel> getProducts() {
        return productRepository.findAll();
    }
    
    
}
