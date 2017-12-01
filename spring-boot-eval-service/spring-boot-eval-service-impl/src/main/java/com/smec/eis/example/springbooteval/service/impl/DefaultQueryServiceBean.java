package com.smec.eis.example.springbooteval.service.impl;

import com.querydsl.core.types.EntityPath;
import com.querydsl.core.types.Predicate;
import com.smec.eis.example.springbooteval.service.DefaultQueryService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@Stateless
public class DefaultQueryServiceBean implements DefaultQueryService {

    @Inject
    @PrimaryEM
    private EntityManager entityManager;

    @Override
    public List query(EntityPath from, Predicate predicate) {
        QueryDslDAO queryDslDAO = new QueryDslDAO(entityManager);
        List resultList = queryDslDAO.query(from, predicate);
        return resultList;
    }

    @Override
    public List query(EntityPath from, Predicate predicate, int offset, int limit) {
        return null;
    }
}
