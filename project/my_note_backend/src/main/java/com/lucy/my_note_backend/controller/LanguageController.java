package com.lucy.my_note_backend.controller;

import com.lucy.my_note_backend.repository.LanguageDAO;
import com.lucy.my_note_backend.repository.entity.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class LanguageController {

    @Autowired
    private LanguageDAO languageDAO;

    @GetMapping("/languages")
    public String getLanguages() {
        return languageDAO.selectLanguagesAll().toString();
    }

    @GetMapping("/language/{language}")
    public String getLanguage(@PathVariable("language") String languageName) {
        return languageDAO.selectLanguage(languageName).toString();
    }

    @PostMapping("/language")
    public String addLanguage(@RequestBody Language language) {
        System.out.println(language);
        int result = languageDAO.addLanguage(language);

        String returnMessage = "";

        if (result == 1) {
            returnMessage = language.getLanguage_name() + " 이 저장되었습니다.";
        } else {
            returnMessage = language.getLanguage_name() + " 저장 실패되었습니다.";
        }
        return returnMessage;
    }

    @PutMapping("/language")
    public String updateLanguage(@RequestBody Language language) {
        System.out.println(language);
        long result = languageDAO.updateLanguage(language);
        return "";
    }

}
