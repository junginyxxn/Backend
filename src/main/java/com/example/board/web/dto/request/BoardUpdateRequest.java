package com.example.board.web.dto.request;

import lombok.Builder;
import lombok.Value;
import lombok.With;

@With
@Value
@Builder
public class BoardUpdateRequest {
    String title;

    String content;
}
