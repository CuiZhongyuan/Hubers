package com.hubers.api.service.impl;

import com.hubers.api.service.CaseApiService;
import com.hubers.utils.JsonUtils;
import com.hubers.utils.RestTemplateUtils;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Service
public class CaseApiServiceImpl implements CaseApiService {


    public String create(Map<String, Object> reqMap) throws Exception {
        // 请求地址
        String url = (String) reqMap.get("url");
        // 请求方式
        String method = (String) reqMap.get("httpMethod");
        // header
        String header = (String) reqMap.get("header");
        // 转map或者list
        Map<String, Object> headerMap = JsonUtils.json2map(header);
        Map<String, String> reqHeader = new HashMap<>();
        Set<String> keySet = headerMap.keySet();
        keySet.forEach(key -> reqHeader.put(key, (String) headerMap.get(key)));
        System.out.println("header:"+ header);
        String paramType = (String) reqMap.get("paramType");
        // param
        String param = (String) reqMap.get("params");
        String resData = "";
        if ("form-data".equals(paramType)) {
            if ("get".equalsIgnoreCase(method)) {
                resData = RestTemplateUtils.get(url, reqHeader, String.class).getBody();
                return JsonUtils.jsonFormatter(resData);
            }
        } else if ("json".equals(paramType)) {
            if ("post".equalsIgnoreCase(method)) {
                resData = RestTemplateUtils.post(url, reqHeader, param, String.class).getBody();
                return JsonUtils.jsonFormatter(resData);
            }
        }else {
            if ("post".equalsIgnoreCase(method)){
                resData = RestTemplateUtils.post(url,reqHeader,param,String.class).getBody();
                return JsonUtils.jsonFormatter(resData);
            }
        }
        return "请求有误，请检查";
    }
}
