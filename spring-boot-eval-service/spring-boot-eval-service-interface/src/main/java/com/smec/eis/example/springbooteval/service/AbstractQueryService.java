package com.smec.eis.example.springbooteval.service;

import com.querydsl.core.types.EntityPath;
import com.querydsl.core.types.Predicate;

import java.util.List;

public abstract class AbstractQueryService implements QueryService {

    @Override
    public <T> List<T> query(EntityPath<T> from, Predicate predicate) {
        List<T> resultList = getQueryDslSupport().query(from, predicate);
        return resultList;
    }

    @Override
    public <T> List<T> query(EntityPath<T> from, Predicate predicate, int offset, int limit) {
        List<T> resultList = getQueryDslSupport().query(from, predicate, offset, limit);
        return resultList;
    }

    public abstract QueryDslSupport getQueryDslSupport();
}
