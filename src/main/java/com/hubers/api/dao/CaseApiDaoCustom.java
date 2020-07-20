package com.hubers.api.dao;

import com.hubers.api.dto.CaseApiDataDTO;
import com.hubers.api.entity.CaseApiData;

import java.util.List;


public interface CaseApiDaoCustom {

    List<CaseApiData> findKey(CaseApiDataDTO caseApiDataDTO, Boolean pageFlag, String sort, String order);
    long count(CaseApiDataDTO caseApiDataDTO);
}
