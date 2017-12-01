package com.smec.eis.example.springbooteval.service.impl;

import com.querydsl.core.types.EntityPath;
import com.querydsl.core.types.Predicate;
import com.smec.eis.example.springbooteval.service.QueryDslSupport;
import org.apache.deltaspike.data.spi.DelegateQueryHandler;
import org.apache.deltaspike.data.spi.QueryInvocationContext;

import javax.inject.Inject;
import java.util.List;

public class QueryDslRepositoryExtension<T> implements QueryDslSupport<T>, DelegateQueryHandler {

    @Inject
    private QueryInvocationContext context;

    @Override
    public List<T> query(EntityPath<T> from, Predicate predicate) {
        QueryDslDAO queryDslDAO = new QueryDslDAO(context.getEntityManager());
        List<T> resultList = queryDslDAO.query(from, predicate);
        return resultList;
    }

    @Override
    public List<T> query(EntityPath<T> from, Predicate predicate, int offset, int limit) {
        QueryDslDAO queryDslDAO = new QueryDslDAO(context.getEntityManager());
        List<T> resultList = queryDslDAO.query(from, predicate, offset, limit);
        return resultList;
    }
}
