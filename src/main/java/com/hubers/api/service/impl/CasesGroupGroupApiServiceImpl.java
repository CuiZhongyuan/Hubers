package com.hubers.api.service.impl;

import com.hubers.api.dao.CaseApiDao;
import com.hubers.api.dao.CasesGroupApiDao;
import com.hubers.api.dto.CaseApiDataDTO;
import com.hubers.api.entity.CaseApiData;
import com.hubers.api.entity.CasesGroupApiData;
import com.hubers.api.service.CasesGroupApiService;
import com.hubers.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class CasesGroupGroupApiServiceImpl implements CasesGroupApiService {
    @Autowired
    CasesGroupApiDao casesGroupApiDao;
    @Autowired
    CaseApiDao caseAPIDao;

    @Override
    public List<CasesGroupApiData> findList(HttpServletRequest request) {
        return casesGroupApiDao.findAll();
    }

    @Override
    public Page<CasesGroupApiData> page(int page, int rows) {
        PageRequest pageRequest = PageRequest.of((page-1)*rows,rows);
        return casesGroupApiDao.findAll(pageRequest);
    }

    /**查询当前用例分组下的用例明细
     *
     * @return*/
    public List<CaseApiData> findCaseApiData(Long groupId){
        return caseAPIDao.findByGroupId(groupId);
    }

    /**静态查询
     * 根据关键字查询
     * */
    @Override
    public List<CaseApiData> findValue(Long groupId, String value) {
        return caseAPIDao.findByGroupId(groupId,  value);
    }

    /**动态查询分组下用例字段key
     * 获取分页数据，有查询条件，有排序
     * */

    @Override
    public List<CaseApiData> findKey(CaseApiDataDTO caseApiDataDTO) {
        return caseAPIDao.findKey(caseApiDataDTO,false,caseApiDataDTO.getSort(),caseApiDataDTO.getOrder());
    }
    /**
     * 用例分组名称查询
     * */
    @Override
    public List<CasesGroupApiData> findName(String groupName) {
        List<CasesGroupApiData> byGroupnameLike = casesGroupApiDao.findByGroupnameLike("%"+groupName+"%");
        return byGroupnameLike;
    }


    /**
     * 新建测试分组
     * */
    @Override
    public CasesGroupApiData createGroup(CasesGroupApiData casesGroupApiData) {
        CasesGroupApiData save = casesGroupApiDao.save(casesGroupApiData);
        return save;
    }

    @Override
    public CasesGroupApiData update(CasesGroupApiData casesGroupApiData) {
        if (casesGroupApiData.getId() !=null){
           return casesGroupApiDao.save(casesGroupApiData);
        }
        return null;
    }

    @Override
    public String delete(Long id) {
        CasesGroupApiData casesGroupApiData = casesGroupApiDao.findById(id).orElse(null);
        if (null != casesGroupApiData && casesGroupApiData.getId() == id){
            casesGroupApiDao.deleteById(id);
            return "删除成功";
        }else {
            return "用例分组不存在";
        }
    }

    /**
     * 选择对应分组保存测试用例
     * */
    @Override
    public CaseApiData create(Map<String,Object> reqMap) throws Exception {


        if (reqMap.containsKey("groupid")){
            // 请求地址
            String url = (String) reqMap.get("url");
            // 请求方式
            String httpMethod = (String) reqMap.get("httpMethod");
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
            Long groupid = (Long) reqMap.get("groupid");
            CaseApiData caseApiData = new CaseApiData();
            caseApiData.setUrl(url);
            caseApiData.setHttpMethod(httpMethod);
            caseApiData.setHeader(header);
            caseApiData.setParamType(paramType);
            caseApiData.setBody(param);
            caseApiData.setGroupId(groupid);
            return caseAPIDao.save(caseApiData);
        }else {
            Object groupName = reqMap.get("groupName");
            CasesGroupApiData casesGroupApiData = new CasesGroupApiData();
            casesGroupApiData.setGroupname(groupName.toString());
            CasesGroupApiData save = casesGroupApiDao.save(casesGroupApiData);
            Long id = save.getId();
            // 请求地址
            String url = (String) reqMap.get("url");
            // 请求方式
            String httpMethod = (String) reqMap.get("httpMethod");
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
            Long groupid = (Long) reqMap.get("groupid");
            CaseApiData caseApiData = new CaseApiData();
            caseApiData.setUrl(url);
            caseApiData.setHttpMethod(httpMethod);
            caseApiData.setHeader(header);
            caseApiData.setParamType(paramType);
            caseApiData.setBody(param);
            caseApiData.setGroupId(groupid);
            return caseAPIDao.save(caseApiData);
        }
    }
}
