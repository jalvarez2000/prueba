package com.example.prueba.domain.product;

import com.example.prueba.domain.article.ArticleModel;
import com.example.prueba.domain.article.ArticleService;
import com.example.prueba.domain.containedarticle.ContainedArticleModel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class ProductServiceTests {
    @Autowired
    ProductService productService;

    @Test
    @Transactional
    public void saveAndGetProductTest() {
        ProductModel savedProduct = new ProductModel();
        savedProduct.setName("Article 1");
        List<ContainedArticleModel> containedArticles = new ArrayList<>();
        ContainedArticleModel containedArticle = new ContainedArticleModel();   
        containedArticle.setArtId(100);
        containedArticle.setAmountOf(1);
        containedArticles.add(containedArticle);
        savedProduct.setContainedArticles(containedArticles);

        productService.saveProduct(savedProduct);
        ProductModel product = productService.getProduct(savedProduct.getId()).get();
        
        assert product.getName().equals("Article 1");
        assert product.getContainedArticles().get(0).getArtId() == 100;      
    }


    @Test
    public void getProductsTest() {
        Iterable<ProductModel> productModels = productService.getProducts();
        assert productModels.iterator().hasNext();
    }

}
