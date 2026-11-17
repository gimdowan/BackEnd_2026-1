package com.example.demo;

import java.time.LocalDateTime;

public class ArticleResponse {

    private final Long id;
    private final String title;
    private final String author;
    private final LocalDateTime date;
    private final String content;

    public ArticleResponse(Long id, String title, String author, LocalDateTime date, String content) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.date = date;
        this.content = content;
    }

    public Long getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public LocalDateTime getDate() { return date; }
    public String getContent() { return content; }
}
