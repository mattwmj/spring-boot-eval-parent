package com.smec.eis.example.springbooteval.service.impl;

import com.querydsl.core.types.EntityPath;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQueryFactory;

import javax.persistence.EntityManager;
import java.util.List;

public class QueryDslDAO {

    private final EntityManager entityManager;

    public QueryDslDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public <T> List<T> query(EntityPath<T> from, Predicate predicate) {
        JPAQueryFactory queryFactory = new JPAQueryFactory(entityManager);
        List<T> resultList = queryFactory.selectFrom(from).where(predicate).fetch();
        return resultList;
    }

    public <T> List<T> query(EntityPath<T> from, Predicate predicate, int offset, int limit) {
        JPAQueryFactory queryFactory = new JPAQueryFactory(entityManager);
        List<T> resultList = queryFactory.selectFrom(from).where(predicate).offset(offset).limit(limit).fetch();
        return resultList;
    }

}
