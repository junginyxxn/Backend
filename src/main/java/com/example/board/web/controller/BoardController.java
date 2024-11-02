package com.example.board.web.controller;

import com.example.board.application.service.BoardService;
import com.example.board.web.dto.request.BoardCreateRequest;
import com.example.board.web.dto.request.BoardUpdateRequest;
import com.example.board.web.dto.response.BoardResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/boards")
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/{id}")
    public BoardResponseDto findById(@PathVariable Long id) {
        return boardService.findById(id);
    }

    @GetMapping
    public Page<BoardResponseDto> findAll(Pageable pageable) {
        return boardService.findAll(pageable);
    }

    @PostMapping
    public BoardResponseDto create(@RequestBody BoardCreateRequest request) {
        return boardService.create(request);
    }

    @PutMapping("/{id}")
    public BoardResponseDto update(@PathVariable Long id, @RequestBody BoardUpdateRequest request) {
        return boardService.update(id, request);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Long id) {
        return boardService.delete(id);
    }
}
