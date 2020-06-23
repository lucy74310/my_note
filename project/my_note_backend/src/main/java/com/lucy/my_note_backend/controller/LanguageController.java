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

    @GetMapping("/language/{language_name}")
    public String getLanguage(@PathVariable("language_name") String languageName) {
        return languageDAO.selectLanguage(languageName).toString();
    }

    @PostMapping("/language")
    public String addLanguage(@RequestBody Language language) {
        System.out.println(language);
        int result = languageDAO.addLanguage(language);
        System.out.println(result);
        return language.toString();
    }

    @PutMapping("/language")
    public String updateLanguage(@RequestBody Language language) {
        System.out.println(language);
        int result = languageDAO.updateLanguage(language);
        System.out.println(result);
        return language.toString();
    }


    @DeleteMapping("/language/{language_no}")
    public String deleteLanguage(@PathVariable("language_no") Long languageNo) {
        Language language = new Language(languageNo);
        int result = languageDAO.deleteLanguage(language);
        System.out.println(result);
        return language.toString();
    }

}
