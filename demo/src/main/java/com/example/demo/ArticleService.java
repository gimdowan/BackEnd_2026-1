package com.example.demo;

import org.springframework.stereotype.Service;

@Service
public class ArticleService {

    private final ArticleRepository articleRepository;
    private final MemberRepository memberRepository;

    public ArticleService(ArticleRepository articleRepository, MemberRepository memberRepository) {
        this.articleRepository = articleRepository;
        this.memberRepository = memberRepository;
    }

    public ArticleResponse findById(Long id) {
        Article article = articleRepository.findById(id);
        if (article == null) {
            return null;
        }
        return toResponse(article);
    }

    public ArticleResponse create(ArticleRequest request) {
        Article article = new Article(request.authorId(), request.boardId(), request.title(), request.content());
        return toResponse(articleRepository.save(article));
    }

    public ArticleResponse update(Long id, ArticleRequest request) {
        Article article = articleRepository.findById(id);
        if (article == null) {
            return null;
        }
        article.update(request.title(), request.content());
        return toResponse(article);
    }

    public boolean delete(Long id) {
        return articleRepository.delete(id) != null;
    }

    private ArticleResponse toResponse(Article article) {
        Member author = memberRepository.findById(article.getAuthorId());
        String authorName = (author == null) ? "알 수 없음" : author.getName();
        return new ArticleResponse(
                article.getId(),
                article.getTitle(),
                authorName,
                article.getCreatedDate(),
                article.getContent()
        );
    }
}
