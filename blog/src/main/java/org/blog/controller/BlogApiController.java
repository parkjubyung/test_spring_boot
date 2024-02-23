package org.blog.controller;

import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.blog.domain.Article;
import org.blog.dto.AddArticleRequest;
import org.blog.dto.ArticleResponse;
import org.blog.dto.UpdateArticleRequest;
import org.blog.service.BlogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class BlogApiController {

    private final BlogService blogService;

    @PostMapping("/api/articles")
    public ResponseEntity<Article> addArticle(@RequestBody AddArticleRequest request) {
        Article savedArticle = blogService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedArticle);
    }

    @GetMapping("/api/articles")
    public ResponseEntity<List<ArticleResponse>> getArticles() {
        List<ArticleResponse> articles = blogService.findAll()
                .stream()
                .map(ArticleResponse::new)
                .toList();
        return ResponseEntity.status(HttpStatus.OK)
                .body(articles);
    }

    @GetMapping("/api/articles/{id}")
    public ResponseEntity<ArticleResponse> getArticle(@PathVariable long id) {
        ArticleResponse articleResponse = new ArticleResponse(blogService.findById(id));
        return ResponseEntity.ok()
                .body(articleResponse);
    }

    @DeleteMapping("/api/articles/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable long id) {
        blogService.deleteById(id);

        return ResponseEntity.ok().build();
    }

    @PutMapping("/api/articles/{id}")
    public ResponseEntity<Article> updateArticle(@PathVariable long id,
                                                         @RequestBody UpdateArticleRequest request) {
        return ResponseEntity.ok().body(
                blogService.update(id, request));
    }



}
