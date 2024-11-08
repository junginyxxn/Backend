package com.example.board.application.mapper;

import com.example.board.domain.model.Board;
import com.example.board.domain.payload.BoardCreatePayload;
import com.example.board.domain.payload.BoardUpdatePayload;
import com.example.board.web.dto.request.BoardCreateRequest;
import com.example.board.web.dto.request.BoardUpdateRequest;
import com.example.board.web.dto.response.BoardResponseDto;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-02T23:43:25+0900",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.10.2.jar, environment: Java 22.0.2 (Amazon.com Inc.)"
)
public class BoardMapperImpl implements BoardMapper {

    @Override
    public BoardCreatePayload toCreatePayload(BoardCreateRequest source) {
        if ( source == null ) {
            return null;
        }

        BoardCreatePayload.BoardCreatePayloadBuilder boardCreatePayload = BoardCreatePayload.builder();

        boardCreatePayload.title( source.getTitle() );
        boardCreatePayload.content( source.getContent() );

        return boardCreatePayload.build();
    }

    @Override
    public BoardUpdatePayload toUpdatePayload(BoardUpdateRequest source) {
        if ( source == null ) {
            return null;
        }

        BoardUpdatePayload.BoardUpdatePayloadBuilder boardUpdatePayload = BoardUpdatePayload.builder();

        boardUpdatePayload.title( source.getTitle() );
        boardUpdatePayload.content( source.getContent() );

        return boardUpdatePayload.build();
    }

    @Override
    public BoardResponseDto toResponse(Board source) {
        if ( source == null ) {
            return null;
        }

        BoardResponseDto.BoardResponseDtoBuilder boardResponseDto = BoardResponseDto.builder();

        boardResponseDto.id( source.getId() );
        boardResponseDto.title( source.getTitle() );
        boardResponseDto.content( source.getContent() );

        return boardResponseDto.build();
    }
}
