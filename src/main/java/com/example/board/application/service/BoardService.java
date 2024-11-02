package com.example.board.application.service;

import com.example.board.application.mapper.BoardMapper;
import com.example.board.domain.model.Board;
import com.example.board.domain.payload.BoardCreatePayload;
import com.example.board.domain.payload.BoardUpdatePayload;
import com.example.board.domain.repository.BoardRepository;
import com.example.board.web.dto.request.BoardCreateRequest;
import com.example.board.web.dto.request.BoardUpdateRequest;
import com.example.board.web.dto.response.BoardResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BoardService {

    private final BoardRepository boardRepository;

    public BoardResponseDto findById(Long id) {
        return boardRepository.findById(id)
                .map(BoardMapper.INSTANCE::toResponse)
                .orElseThrow(() -> new IllegalArgumentException("게시글을 찾을 수 없습니다."));
    }

    public Page<BoardResponseDto> findAll(Pageable pageable) {
        return boardRepository.findAll(pageable)
                .map(BoardMapper.INSTANCE::toResponse);
    }

    @Transactional
    public BoardResponseDto create(BoardCreateRequest request) {
        BoardCreatePayload payload = BoardMapper.INSTANCE.toCreatePayload(request);
        Board board = Board.create(payload);
        board = boardRepository.save(board);
        return BoardMapper.INSTANCE.toResponse(board);
    }

    @Transactional
    public BoardResponseDto update(Long id, BoardUpdateRequest request) {
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("게시글을 찾을 수 없습니다."));
        BoardUpdatePayload payload = BoardMapper.INSTANCE.toUpdatePayload(request);
        board.update(payload);
        board = boardRepository.save(board);
        return BoardMapper.INSTANCE.toResponse(board);
    }

    @Transactional
    public boolean delete(Long id) {
        boardRepository.deleteById(id);
        return true;
    }
}
