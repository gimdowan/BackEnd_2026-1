package com.example.demo;

import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class BoardRepository {

    private final Map<Long, Board> boards = new ConcurrentHashMap<>();
    private final AtomicLong nextId = new AtomicLong(1);

    public Board save(Board board) {
        long id = nextId.getAndIncrement();
        board.setId(id);
        boards.put(id, board);
        return board;
    }

    public Board findById(Long id) {
        return boards.get(id);
    }
}
