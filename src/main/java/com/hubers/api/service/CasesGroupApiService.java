package com.hubers.api.service;

import com.hubers.api.dto.CaseApiQueryDataDTO;
import com.hubers.api.dto.CaseApiResDataDTO;
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

    Object createGroup(CasesGroupApiData casesGroupApiData) throws Exception;

    CasesGroupApiData update(CasesGroupApiData casesGroupApiData);

    String delete(Long id);

    List<CaseApiResDataDTO> findCaseApiData(Long groupId);

    List<CaseApiData> findValue(Long groupId,String value);

    List<CasesGroupApiData> findName(String groupName);
    List<CaseApiData> findKey(CaseApiQueryDataDTO caseApiQueryDataDTO);
}
