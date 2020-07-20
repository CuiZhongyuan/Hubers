package com.hubers.api.entity;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(CaseApiData.class)
public class CaseApiData_ {

    public static volatile SingularAttribute<CaseApiData,String> httpMethod;
    public static volatile SingularAttribute<CaseApiData,String> url;
    public static volatile SingularAttribute<CaseApiData,Long> groupId;
}
