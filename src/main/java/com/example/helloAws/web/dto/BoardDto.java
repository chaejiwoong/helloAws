package com.example.helloAws.web.dto;

import com.example.helloAws.domain.Board;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BoardDto {

    private Long id;

    private String title;

    private String writer;

    private String contents;

}