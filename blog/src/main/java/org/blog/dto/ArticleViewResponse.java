package org.blog.dto;

import lombok.Getter;
import org.blog.domain.Article;

import java.time.LocalDateTime;

@Getter
public class ArticleViewResponse {
    private final Long id;
    private final String title;
    private final String content;
    private final LocalDateTime createdAt;

    public ArticleViewResponse(Article article) {
        id = article.getId();
        title = article.getTitle();
        content = article.getContent();
        createdAt = article.getCreatedAt();
    }
}
