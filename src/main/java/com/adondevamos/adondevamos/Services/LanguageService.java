package com.adondevamos.adondevamos.Services;

import com.adondevamos.adondevamos.Entities.Language;
import com.adondevamos.adondevamos.Repositories.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguageService {
    @Autowired
    private LanguageRepository languageRepository;

    public List<Language> getAllLanguages(){
        return languageRepository.findAll();
    }
}
