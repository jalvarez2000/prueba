package com.example.prueba.domain.article;

import org.springframework.web.bind.annotation.*;

@RestController
public class ArticleController {
    ArticleService articleService;
    
    public ArticleController(ArticleService articuloService) {
        this.articleService = articuloService;
    }

    @PostMapping("/article")
    public ArticleModel saveArticle(@RequestBody ArticleModel articleModel) {
        articleService.saveArticle(articleModel);
        return articleModel;
    }

    
    @GetMapping("/article/{id}")
    private ArticleModel getArticle(@PathVariable Integer id) {
        return articleService.getArticle(id).get();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/article")
    private Iterable<ArticleModel> getArticles() {
        return articleService.getArticles();
    }
}
