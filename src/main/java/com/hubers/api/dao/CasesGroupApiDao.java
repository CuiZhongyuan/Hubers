package com.hubers.api.dao;

import com.hubers.api.entity.CasesGroupApiData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CasesGroupApiDao extends JpaRepository<CasesGroupApiData,Long> {

    List<CasesGroupApiData> findByGroupnameLike(String groupName);
}
