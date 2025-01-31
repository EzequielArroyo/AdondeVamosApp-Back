package com.adondevamos.adondevamos.Services;

import com.adondevamos.adondevamos.Entities.Interest;
import com.adondevamos.adondevamos.Repositories.InterestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class InterestService {
    @Autowired
    private InterestRepository interestRepository;

    public List<Interest> getAllLanguages(){
        return interestRepository.findAll();
    }
}
