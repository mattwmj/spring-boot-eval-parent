package com.smec.eis.example.springbooteval.service.impl;

import com.querydsl.core.types.EntityPath;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQueryFactory;
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
        JPAQueryFactory queryFactory = new JPAQueryFactory(context.getEntityManager());
        List<T> resultList = queryFactory.selectFrom(from).where(predicate).fetch();
        return resultList;
    }

    @Override
    public List<T> query(EntityPath<T> from, Predicate predicate, long offset, long limit) {
        JPAQueryFactory queryFactory = new JPAQueryFactory(context.getEntityManager());
        List<T> resultList = queryFactory.selectFrom(from).where(predicate).offset(offset).limit(limit).fetch();
        return resultList;
    }
}
