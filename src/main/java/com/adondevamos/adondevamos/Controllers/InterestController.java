package com.adondevamos.adondevamos.Controllers;


import com.adondevamos.adondevamos.Entities.Interest;
import com.adondevamos.adondevamos.Entities.Language;
import com.adondevamos.adondevamos.Services.InterestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/interests")
public class InterestController {
    @Autowired
    private InterestService interestService;
    public ResponseEntity<List<Interest>> getAllInterests(){
        List<Interest> interestList = interestService.getAllLanguages();
        return ResponseEntity.ok(interestList);
    }

}
