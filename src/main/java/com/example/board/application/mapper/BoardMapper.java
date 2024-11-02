package com.example.board.application.mapper;

import com.example.board.domain.model.Board;
import com.example.board.domain.payload.BoardCreatePayload;
import com.example.board.domain.payload.BoardUpdatePayload;
import com.example.board.web.dto.request.BoardCreateRequest;
import com.example.board.web.dto.request.BoardUpdateRequest;
import com.example.board.web.dto.response.BoardResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BoardMapper {

    BoardMapper INSTANCE = Mappers.getMapper(BoardMapper.class);

    @Mapping(target = "title", source = "title")
//    @Mapping(target = "content", ignore = true)
    BoardCreatePayload toCreatePayload(BoardCreateRequest source);

    BoardUpdatePayload toUpdatePayload(BoardUpdateRequest source);

    BoardResponseDto toResponse(Board source);
}
