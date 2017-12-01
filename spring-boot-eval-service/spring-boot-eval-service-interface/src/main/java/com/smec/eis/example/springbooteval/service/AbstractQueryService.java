package com.smec.eis.example.springbooteval.service;

import com.querydsl.core.types.EntityPath;
import com.querydsl.core.types.Predicate;

import java.util.List;

public abstract class AbstractQueryService<T> implements QueryService<T> {

    @Override
    public List<T> query(EntityPath<T> from, Predicate predicate) {
        List<T> resultList = getQueryDslSupport().query(from, predicate);
        return resultList;
    }

    @Override
    public List<T> query(EntityPath<T> from, Predicate predicate, long offset, long limit) {
        List<T> resultList = getQueryDslSupport().query(from, predicate, offset, limit);
        return resultList;
    }

    public abstract QueryDslSupport<T> getQueryDslSupport();
}
