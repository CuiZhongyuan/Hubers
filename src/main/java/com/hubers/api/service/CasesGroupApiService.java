package com.hubers.api.service;

import com.hubers.api.dto.CaseApiDataDTO;
import com.hubers.api.entity.CaseApiData;
import com.hubers.api.entity.CasesGroupApiData;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Service
public interface CasesGroupApiService {
    List<CasesGroupApiData> findList(HttpServletRequest request);

    Page<CasesGroupApiData> page(int page, int rows);

    CaseApiData create(Map<String, Object> reqMap) throws Exception;

    CasesGroupApiData createGroup(CasesGroupApiData casesGroupApiData);

    CasesGroupApiData update(CasesGroupApiData casesGroupApiData);

    String delete(Long id);

    List<CaseApiData> findCaseApiData(Long groupId);

    List<CaseApiData> findValue(Long groupId,String value);

    List<CasesGroupApiData> findName(String groupName);
    List<CaseApiData> findKey(CaseApiDataDTO caseApiDataDTO);
}
