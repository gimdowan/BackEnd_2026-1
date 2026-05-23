package com.example.demo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping("/article")
public class ArticleController {
    private final Map<Integer, Map<String, Object>> articleStore = new HashMap<>();
    private final AtomicInteger nextId = new AtomicInteger(1);

    @PostMapping()
    public ResponseEntity<Map<String, Object>> createArticle(
            @RequestBody Map<String, Object> article) {

        int id = nextId.getAndIncrement();

        article.put("id", id);

        articleStore.put(id, article);

        return ResponseEntity.status(201).body(article);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getArticle(@PathVariable int id) {

        Map<String, Object> article = articleStore.get(id);

        if (article == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(article);
    }

    @PutMapping("/{id}")
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

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable int id) {

        if (!articleStore.containsKey(id)) {
            return ResponseEntity.notFound().build();
        }

        articleStore.remove(id);

        return ResponseEntity.noContent().build();
    }
}
