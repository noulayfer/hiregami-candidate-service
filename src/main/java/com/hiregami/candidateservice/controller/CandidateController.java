package com.hiregami.candidateservice.controller;

import com.hiregami.candidateservice.service.CandidateProfileService;
import com.hiregami.data_extraction_library.dto.CandidateProfile;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.InputStream;

@RestController
@AllArgsConstructor
@RequestMapping("/candidate")
public class CandidateController {

    @Autowired
    CandidateProfileService candidateService;

    @PostMapping(consumes = "application/pdf")
    public CandidateProfile createProfile(@RequestHeader("Content-Type") String contentType, InputStream inputStream) {
        return candidateService.createCandidateProfile(contentType, inputStream);
    }
}
