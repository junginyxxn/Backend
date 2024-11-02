package com.example.board.domain.payload;

import lombok.Builder;
import lombok.Value;
import lombok.With;

@With
@Value
@Builder
public class BoardUpdatePayload {
    String title;

    String content;
}
