package com.smec.eis.example.springbooteval.service;

import com.querydsl.core.types.EntityPath;
import com.querydsl.core.types.Predicate;

import java.util.List;

public interface QueryDslSupport<T> {

    List<T> query(EntityPath<T> from, Predicate predicate);

    List<T> query(EntityPath<T> from, Predicate predicate, int offset, int limit);

}
