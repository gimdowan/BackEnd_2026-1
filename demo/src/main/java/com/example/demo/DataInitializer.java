package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final MemberRepository memberRepository;
    private final BoardRepository boardRepository;
    private final ArticleRepository articleRepository;

    public DataInitializer(MemberRepository memberRepository,
                           BoardRepository boardRepository,
                           ArticleRepository articleRepository) {
        this.memberRepository = memberRepository;
        this.boardRepository = boardRepository;
        this.articleRepository = articleRepository;
    }

    @Override
    public void run(String... args) {
        Board board = boardRepository.save(new Board("자유게시판"));
        for (int i = 0; i < 4; i++) {
            Member member = memberRepository.save(
                    new Member("회원" + i, "member" + i + "@bcsd.com", "password" + i));
            articleRepository.save(
                    new Article(member.getId(), board.getId(), "제목" + i, "내용입니다!!".repeat(i)));
        }
    }
}
