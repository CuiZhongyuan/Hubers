package com.hubers.api.dto;


import lombok.*;

import java.util.Map;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class CaseApiResDataDTO {
    private String url;

    private String httpMethod;

    private String header;

    private String paramType;

    private Map<String, Object> body;

    public CaseApiResDataDTO(String url, String httpMethod, String header, String paramType) {
        this.url = url;
        this.httpMethod = httpMethod;
        this.header = header;
        this.paramType = paramType;
    }
}
