package com.lucy.my_note_backend.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class WordController {

    @PostMapping("/word")
    public String addWord() {
        return "add word";
    }

    @PutMapping("/word")
    public String modifyWord() {
        return "modify word";
    }

    @DeleteMapping("/word")
    public String deleteWord() {
        return "delete word";
    }

    @GetMapping("/words")
    public String getWordList() {
        return "word list";
    }


}
