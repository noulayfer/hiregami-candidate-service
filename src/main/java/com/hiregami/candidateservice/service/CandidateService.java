package com.hiregami.candidateservice.service;

import com.hiregami.data_extraction_library.dto.CandidateProfile;

import java.io.InputStream;

public interface CandidateService {
    CandidateProfile createCandidateProfile(String contentType, InputStream inputStream);
}
