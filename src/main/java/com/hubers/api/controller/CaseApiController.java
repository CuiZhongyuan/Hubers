package com.hubers.api.controller;

import com.hubers.api.service.CaseApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(value = "/api")
public class CaseApiController {

    @Autowired
    private CaseApiService caseApiService;

    @PostMapping
    public String getMethod(@RequestBody Map<String, Object> reqMap) throws Exception {
        return caseApiService.create(reqMap);
    }

}
