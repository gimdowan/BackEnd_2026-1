package com.example.demo;

public record ArticleRequest(Long authorId, Long boardId, String title, String content) {
}
