package com.example.demo;

import org.springframework.stereotype.Repository;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class ArticleRepository {

    private final Map<Long, Article> articles = new ConcurrentHashMap<>();
    private final AtomicLong nextId = new AtomicLong(1);

    public Article save(Article article) {
        long id = nextId.getAndIncrement();
        article.setId(id);
        articles.put(id, article);
        return article;
    }

    public List<Article> findAll() {
        return articles.values().stream()
                .sorted(Comparator.comparing(Article::getId))
                .toList();
    }

    public List<Article> findAllByBoardId(Long boardId) {
        return findAll().stream()
                .filter(article -> article.getBoardId().equals(boardId))
                .toList();
    }

    public Article findById(Long id) {
        return articles.get(id);
    }

    public Article delete(Long id) {
        return articles.remove(id);
    }
}
