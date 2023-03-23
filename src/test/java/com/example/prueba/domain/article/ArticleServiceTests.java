package com.example.prueba.domain.article;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ArticleServiceTests {
    @Autowired
    ArticleService articleService;
    
    @Test
    public void saveAndGetArticleTest() {
        ArticleModel savedArticle = new ArticleModel();
        savedArticle.setArtId(100);
        savedArticle.setName("Article 1");
        savedArticle.setStock(10);
        
        articleService.saveArticle(savedArticle);
        ArticleModel article = articleService.getArticle(savedArticle.getArtId()).get();
        
        assert article.getName().equals("Article 1");
    }
    
    
    @Test
    public void getArticlesTest() {
        Iterable<ArticleModel> articles = articleService.getArticles();
        assert articles.iterator().hasNext();
    }
    
}
