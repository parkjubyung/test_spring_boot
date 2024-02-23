package org.blog.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.blog.domain.Article;
import org.blog.dto.AddArticleRequest;
import org.blog.dto.UpdateArticleRequest;
import org.blog.repository.BlogRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor // final이 붙거나, @NotNull이 붙은 필드의 생성자 추가.
@Service
public class BlogService {
    private final BlogRepository blogRepository;

    public Article save(AddArticleRequest request) {
        return blogRepository.save(request.toEntity());
    }

    public List<Article> findAll() {
        return blogRepository.findAll();
    }

    public Article findById(long id) {
        return blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found " + id));
    }

    public void deleteById(long id) {
        blogRepository.deleteById(id);
    }

    @Transactional
    public Article update(long id, UpdateArticleRequest request) {
        Article article = findById(id);
        article.update(request.getTitle(), request.getContent());

        return article;
    }


}
