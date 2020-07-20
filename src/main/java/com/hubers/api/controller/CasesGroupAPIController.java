package com.hubers.api.controller;

import com.hubers.api.dto.CaseApiDataDTO;
import com.hubers.api.entity.CaseApiData;
import com.hubers.api.entity.CasesGroupApiData;
import com.hubers.api.service.CasesGroupApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/cases-group")
public class CasesGroupAPIController {
    @Autowired
    CasesGroupApiService casesGroupApiService;
    /**动态查询分组下用例字段key
     * 获取分页数据，有查询条件，有排序API记录
     * */
    @GetMapping(value = "/api/key/list")
    public List<CaseApiData> apiKeyList(CaseApiDataDTO caseApiDataDTO){
        return  casesGroupApiService.findKey(caseApiDataDTO);
    }

    /**静态查询
     * 根据关键字查询API记录
     * */
    @GetMapping(value = "/api/value/list")
    public List<CaseApiData> apiValueList(Long groupId ,String value){
        return casesGroupApiService.findValue(groupId,value);
    }

    /**
     * 获取当前用例分组下的用例明细
     * */
    @GetMapping(value = "/api/list")
    public List<CaseApiData> apiList(Long groupId){
        return  casesGroupApiService.findCaseApiData(groupId);
    }

    /**
     * 用例分组名称查询
     *
     * @return*/
    @GetMapping(value = "/name")
    public List<CasesGroupApiData> findCaseApiData(String groupName){
        return  casesGroupApiService.findName(groupName);
    }

    /** 获取所有分组信息
     * */
    @GetMapping(value = "/list")
    public List<CasesGroupApiData> all(HttpServletRequest request){
        return casesGroupApiService.findList(request);
    }

    /**分页查询
     * */
    @GetMapping(value = "/page")
    public Page<CasesGroupApiData> page(int page, int rows){
        return casesGroupApiService.page(page,rows);
    }

    /**创建用例分组
     * */
    @PostMapping(value = "/creatgroup")
    public CasesGroupApiData add(@RequestBody CasesGroupApiData casesGroupApiData){
        return casesGroupApiService.createGroup(casesGroupApiData);
    }

    /**
     * 点击选择用例组保存按钮，新增子用例
     * */
    @PostMapping(value = "/createapi")
    public CaseApiData add(@RequestBody Map<String,Object> reqMap) throws Exception {
        return casesGroupApiService.create(reqMap);
    }


    /**
     * 更新用例分组信息
     * */
    @PutMapping(value = "/update")
    public CasesGroupApiData update(@Valid @RequestBody CasesGroupApiData casesGroupApiData , BindingResult result){
        if (result.hasErrors()){
            return null;
        }
        return casesGroupApiService.update(casesGroupApiData);
    }

    /**
     * 删除用例分组信息
     * */
    @DeleteMapping(value = "/delete/{id}")
    public String delete(@PathVariable Long id){
        return casesGroupApiService.delete(id);
    }

}
