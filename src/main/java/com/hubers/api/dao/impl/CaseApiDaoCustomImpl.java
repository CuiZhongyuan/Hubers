package com.hubers.api.dao.impl;


import cn.hutool.core.util.StrUtil;
import com.hubers.api.dao.CaseApiDaoCustom;
import com.hubers.api.dto.BaseDTO;
import com.hubers.api.dto.CaseApiDataDTO;
import com.hubers.api.entity.CaseApiData;
import com.hubers.api.entity.CaseApiData_;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.List;


public class CaseApiDaoCustomImpl implements CaseApiDaoCustom {

//    EntityManager 是用来对实体Bean 进行操作的辅助类
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<CaseApiData> findKey(CaseApiDataDTO caseApiDataDTO, Boolean pageFlag, String sort, String order) {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<CaseApiData> criteriaQuery = criteriaBuilder.createQuery(CaseApiData.class);
        Root<CaseApiData> root = criteriaQuery.from(CaseApiData.class);
        criteriaQuery.select(root);
        Predicate where = genWhereCondition(caseApiDataDTO, root, criteriaBuilder);
        if (where != null) {
            criteriaQuery.where(where);
        }
        //排序
        TypedQuery<CaseApiData> tq = em.createQuery(criteriaQuery);
        if (pageFlag) {
            BaseDTO.Limit limit = caseApiDataDTO.getLimit();
            tq.setFirstResult(limit.getStartRow()).setMaxResults(limit.getPageSize());
        }
        return tq.getResultList();
    }

    @Override
    public long count(CaseApiDataDTO caseApiDataDTO) {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Long> criteriaQuery = criteriaBuilder.createQuery(Long.class);
        Root<CaseApiData> root = criteriaQuery.from(CaseApiData.class);
        criteriaQuery.select(criteriaBuilder.count(root));
        Predicate where = genWhereCondition(caseApiDataDTO, root, criteriaBuilder);
        if (where != null) {
            criteriaQuery.where(where);
        }
        return em.createQuery(criteriaQuery).getSingleResult();
    }

    private Predicate genWhereCondition(CaseApiDataDTO caseApiDataDTO, Root<CaseApiData> root, CriteriaBuilder
            criteriaBuilder) {
        Predicate where = null;

        Long groupSearch = caseApiDataDTO.getGroudId();
        if (null != groupSearch) {
            Path<Long> groupSearchPath = root.get(CaseApiData_.groupId);
            if (where != null) {
                where = criteriaBuilder.and(where, criteriaBuilder.equal(groupSearchPath, groupSearch));
            } else {
                where = criteriaBuilder.equal(groupSearchPath, groupSearch);
            }
        }

        String httpMethodSearch = caseApiDataDTO.getHttpMethod();
        if (StrUtil.isNotEmpty(httpMethodSearch)) {
            Path<String> httpMethodSearchPath = root.get(CaseApiData_.httpMethod);
            if (where != null) {
                where = criteriaBuilder.and(where, criteriaBuilder.like(httpMethodSearchPath, "%"+httpMethodSearch+"%"));
            } else {
                where = criteriaBuilder.like(httpMethodSearchPath, "%"+httpMethodSearch+"%");
            }
        }

        String urlSearch = caseApiDataDTO.getUrl();
        if (StrUtil.isNotEmpty(urlSearch)) {
            Path<String> urlSearchPath = root.get(CaseApiData_.url);
            if (where != null) {
                where = criteriaBuilder.and(where, criteriaBuilder.like(urlSearchPath, "%" + urlSearch + "%"));
            } else {
                where = criteriaBuilder.like(urlSearchPath, "%" + urlSearch + "%");
            }
        }
        return where;
    }
}
