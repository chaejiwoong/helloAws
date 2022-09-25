package com.example.helloAws.service;

import com.example.helloAws.domain.Board;
import com.example.helloAws.domain.BoardRepository;
import com.example.helloAws.web.dto.BoardDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BoardService {

    private final BoardRepository boardRepository;

    public List<BoardDto> getList() {
        List<Board> list = boardRepository.findAll();
        List<BoardDto> dtos = new ArrayList<>();

        for (Board board : list) {
            dtos.add(new BoardDto(board.getId(), board.getTitle(), board.getWriter(), board.getContents()));
        }

        return dtos;
    }

    @Transactional
    public Long save(BoardDto dto) {

        Board board = Board.builder()
                .title(dto.getTitle())
                .writer(dto.getWriter())
                .contents(dto.getContents())
                .build();

        return boardRepository.save(board).getId();
    }
}
