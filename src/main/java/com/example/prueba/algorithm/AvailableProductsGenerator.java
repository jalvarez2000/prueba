package com.example.prueba.algorithm;

import java.util.ArrayList;
import java.util.Collection;

import com.example.prueba.domain.article.ArticleModel;
import com.example.prueba.domain.product.ProductModel;
import com.example.prueba.dto.ProductAvailabilityDTO;

public class AvailableProductsGenerator {
    public static Iterable<ProductAvailabilityDTO> execute(Iterable<ProductModel> products, Iterable<ArticleModel> articles) {
        Collection<ProductAvailabilityDTO> productAvailabilityDTOCollection = new ArrayList<>();
        
        products.forEach(product -> {
            // Find max number of products contained in the warehouse
            final int[] maxNumberOfProducts = {Integer.MAX_VALUE};
            product.getContainedArticles().forEach(containedArticle -> {
                int numberOfArticles = 0;
                for (ArticleModel article : articles) {
                    if (article.getArtId().equals(containedArticle.getArtId())) {
                        numberOfArticles = article.getStock() / containedArticle.getAmountOf();
                        break;
                    }
                }
                if (numberOfArticles < maxNumberOfProducts[0]) {
                    maxNumberOfProducts[0] = numberOfArticles;
                }
            });
            productAvailabilityDTOCollection.add(
                ProductAvailabilityDTO  
                    .builder()
                    .product(product)
                    .quantity(maxNumberOfProducts[0])
                    .build()    
            );
        });
        
        return productAvailabilityDTOCollection;
    }
}
