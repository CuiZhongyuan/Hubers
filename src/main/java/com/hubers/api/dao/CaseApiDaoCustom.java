package com.hubers.api.dao;

import com.hubers.api.dto.CaseApiQueryDataDTO;
import com.hubers.api.entity.CaseApiData;

import java.util.List;


public interface CaseApiDaoCustom {

    List<CaseApiData> findKey(CaseApiQueryDataDTO caseApiQueryDataDTO, Boolean pageFlag, String sort, String order);
    long count(CaseApiQueryDataDTO caseApiQueryDataDTO);
}
