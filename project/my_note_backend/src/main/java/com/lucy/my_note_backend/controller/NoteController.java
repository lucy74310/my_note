package com.lucy.my_note_backend.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class NoteController {

    @PostMapping("/note")
    public String addNote() {

        return "add note";
    }

    @PutMapping("/note")
    public String modifyNote() {
        return "modify note";
    }

    @DeleteMapping("/note")
    public String deleteNote() {
        return "delete note";
    }

    @GetMapping("/notes")
    public String getNote() {
        return "note list";
    }

}
