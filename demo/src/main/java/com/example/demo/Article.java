package com.example.demo;

public class Article package com.example.demo;

import java.time.LocalDateTime;

public class Article {

    private Long id;
    private Long authorId;
    private Long boardId;
    private String title;
    private String content;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    public Article(Long authorId, Long boardId, String title, String content) {
        this.authorId = authorId;
        this.boardId = boardId;
        this.title = title;
        this.content = content;
        this.createdDate = LocalDateTime.now();
        this.modifiedDate = this.createdDate;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
        this.modifiedDate = LocalDateTime.now();
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getAuthorId() { return authorId; }
    public Long getBoardId() { return boardId; }
    public String getTitle() { return title; }
    public String getContent() { return content; }
    public LocalDateTime getCreatedDate() { return createdDate; }
    public LocalDateTime getModifiedDate() { return modifiedDate; }
}
