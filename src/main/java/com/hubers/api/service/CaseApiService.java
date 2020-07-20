package com.hubers.api.service;


import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public interface CaseApiService {

    String create(Map<String, Object> reqMap) throws Exception;
}
