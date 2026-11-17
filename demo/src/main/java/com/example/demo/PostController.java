package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PostController {

    private final ArticleService articleService;
    private final BoardRepository boardRepository;

    public PostController(ArticleService articleService, BoardRepository boardRepository) {
        this.articleService = articleService;
        this.boardRepository = boardRepository;
    }

    @GetMapping("/posts")
    public String posts(@RequestParam(defaultValue = "1") Long boardId, Model model) {
        Board board = boardRepository.findById(boardId);
        model.addAttribute("boardName", board == null ? "게시판" : board.getName());
        model.addAttribute("articles", articleService.findAllByBoardId(boardId));
        return "posts";
    }
}
