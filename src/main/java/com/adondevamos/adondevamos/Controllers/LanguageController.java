package com.adondevamos.adondevamos.Controllers;

import com.adondevamos.adondevamos.Entities.Language;
import com.adondevamos.adondevamos.Repositories.LanguageRepository;
import com.adondevamos.adondevamos.Services.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/languages")
public class LanguageController {
    @Autowired
    private LanguageService languageService;

    @GetMapping
    public ResponseEntity<List<Language>> getAllLanguages(){
        List<Language> languageList = languageService.getAllLanguages();
        return ResponseEntity.ok(languageList);
    }
}
