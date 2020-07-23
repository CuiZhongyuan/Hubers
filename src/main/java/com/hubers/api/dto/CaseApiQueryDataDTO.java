package com.hubers.api.dto;

import lombok.Data;


/**
 * @author czy
 */
@Data
public class CaseApiQueryDataDTO extends BaseDTO{
    private Long groudId;
    private String url;
    private String httpMethod;
}
