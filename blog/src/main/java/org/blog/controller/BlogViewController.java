package org.blog.controller;

import lombok.RequiredArgsConstructor;
import org.blog.domain.Article;
import org.blog.dto.ArticleListViewResponse;
import org.blog.dto.ArticleViewResponse;
import org.blog.service.BlogService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class BlogViewController {
    private final BlogService service;

    @GetMapping("/articles")
    public String getArticles(Model model) {
        List<ArticleListViewResponse> articles = service.findAll()
                .stream()
                .map(ArticleListViewResponse::new)
                .toList();

        model.addAttribute("articles", articles);
        return "articleList";
    }

    @GetMapping("/articles/{id}")
    public String getArticle(@PathVariable long id, Model model) {
        Article article = service.findById(id);
        model.addAttribute("article", new ArticleViewResponse(article));

        return "article";
    }
}
