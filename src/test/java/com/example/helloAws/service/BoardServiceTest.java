package com.example.helloAws.service;

import com.example.helloAws.domain.Board;
import com.example.helloAws.web.dto.BoardDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootApplication
class BoardServiceTest {

    @Autowired
    private BoardService boardService;

    @Test
    public void register() {

    }

}