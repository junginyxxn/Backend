package com.example.board.domain.model;

import com.example.board.domain.entity.BoardEntity;
import com.example.board.domain.payload.BoardCreatePayload;
import com.example.board.domain.payload.BoardUpdatePayload;
import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.springframework.util.Assert;

import java.util.Optional;

@Entity
@Table(name = "board")
@Getter
@SuperBuilder
@ToString(callSuper = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Access(AccessType.FIELD)
public class Board extends BoardEntity {

    public static Board create(BoardCreatePayload payload) {
        return Board.builder()
                .title(payload.getTitle())
                .content(payload.getContent())
                .build();
    }

    public Board update(BoardUpdatePayload payload) {
        Optional.ofNullable(payload.getTitle())
                .ifPresent(this::updateTitle);

        Optional.ofNullable(payload.getContent())
                .ifPresent(this::updateContent);

        return this;
    }

    public void updateTitle(String title) {
        Assert.notNull(title, "Title must not be null");
        if(title.equals(getTitle()))
            return;
        setTitle(title);
    }

    public void updateContent(String content) {
        Assert.notNull(content, "Content must not be null");
        if(content.equals(getContent()))
            return;
        setContent(content);
    }

}