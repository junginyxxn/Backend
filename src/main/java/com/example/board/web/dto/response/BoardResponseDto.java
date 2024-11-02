package com.example.board.web.dto.response;

import lombok.Builder;
import lombok.Value;
import lombok.With;

@With
@Value
@Builder
public class BoardResponseDto {
    Long id;

    String title;

    String content;
}
