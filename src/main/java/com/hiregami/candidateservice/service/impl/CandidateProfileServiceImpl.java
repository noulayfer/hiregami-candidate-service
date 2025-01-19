package com.hiregami.candidateservice.service.impl;

import com.hiregami.candidateservice.dataProcessor.DataProcessor;
import com.hiregami.candidateservice.service.CandidateService;
import com.hiregami.data_extraction_library.dto.CandidateProfile;
import com.hiregami.data_extraction_library.dto.ProfileContext;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;

@Service
@AllArgsConstructor
public class CandidateProfileServiceImpl implements CandidateService {

    @Autowired
    private DataProcessor aspects;

    public CandidateProfile createCandidateProfile(String contentType, InputStream inputStream) {
        ProfileContext context = createContext(contentType, inputStream);
        aspects.processFile(context);
        aspects.createCandidateProfile(context);
        return retrieveCandidateProfile(context);
    }

    private CandidateProfile retrieveCandidateProfile(ProfileContext context) {
        return context.get("candidateProfile", CandidateProfile.class);
    }

    private ProfileContext createContext(String contentType, InputStream inputStream) {
        ProfileContext context = new ProfileContext();
        context.set("contentType", contentType);
        context.set("inputStream", inputStream);
        return context;
    }
}
