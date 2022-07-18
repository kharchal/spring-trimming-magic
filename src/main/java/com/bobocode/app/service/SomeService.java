package com.bobocode.app.service;

import com.bobocode.trimmer.annotation.Trimmed;
import org.springframework.stereotype.Service;

@Service
@Trimmed
public class SomeService {

    public String processStrings(String s1, String s2) {
        return s1 + ", " + s2;
    }
}
