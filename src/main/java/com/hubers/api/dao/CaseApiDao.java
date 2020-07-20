package com.hubers.api.dao;

import com.hubers.api.entity.CaseApiData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CaseApiDao extends JpaRepository<CaseApiData, Long>,CaseApiDaoCustom {

    List<CaseApiData> findByGroupId(Long groupId);

    @Query(value= "select t.* from h_caseapidata t where t.group_id = :groupId and t.url like %:value% or t.http_method like " +
            " %:value%",nativeQuery = true)
    List<CaseApiData> findByGroupId(@Param("groupId") Long groupId, @Param("value")String value);
}
