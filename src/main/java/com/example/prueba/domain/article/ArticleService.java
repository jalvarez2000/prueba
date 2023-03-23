package com.example.prueba.domain.article;

import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ArticleService {
    ArticleRepository articleRepository;
    
    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }
    
    public void saveArticle(ArticleModel articleModel) {
        articleRepository.save(articleModel);
    }
    
    public Optional<ArticleModel> getArticle(Integer id) {
        return articleRepository.findById(id);
    }
    
    public Iterable<ArticleModel> getArticles() {
        return articleRepository.findAll();
    }
}
