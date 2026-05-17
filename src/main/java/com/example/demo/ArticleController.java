package com.example.demo;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
public class ArticleController {
    private Map<Integer, Map<String, Object>> articleStore = new HashMap<>();
    private int nextId = 1;

    @ResponseBody
    @PostMapping("/article")
    public ResponseEntity<Map<String, Object>> createArticle(
            @RequestBody Map<String, Object> article) {

        int id = nextId++;

        article.put("id", id);

        articleStore.put(id, article);

        return ResponseEntity.status(201).body(article);
    }

    @ResponseBody
    @GetMapping("/article/{id}")
    public ResponseEntity<Map<String, Object>> getArticle(@PathVariable int id) {

        Map<String, Object> article = articleStore.get(id);

        if (article == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(article);
    }

    @ResponseBody
    @PutMapping("/article/{id}")
    public ResponseEntity<Map<String, Object>> updateArticle(
            @PathVariable int id,
            @RequestBody Map<String, Object> article) {

        if (!articleStore.containsKey(id)) {
            return ResponseEntity.notFound().build();
        }

        article.put("id", id);

        articleStore.put(id, article);

        return ResponseEntity.ok(article);
    }
}
