package com.example.helloAws.web;

import com.example.helloAws.service.BoardService;
import com.example.helloAws.web.dto.BoardDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/boards")
    public String getList(Model model) {
        List<BoardDto> list = boardService.getList();
        model.addAttribute("list", list);

        return "boards";
    }

    @GetMapping("/boards/register")
    public String register() {
        log.info("register---");
        return "register";
    }

    @PostMapping("/boards/register")
    public String register(@ModelAttribute BoardDto dto) {

        log.info(dto.toString());

        Long id = boardService.save(dto);

        return "redirect:/boards";
    }
}
