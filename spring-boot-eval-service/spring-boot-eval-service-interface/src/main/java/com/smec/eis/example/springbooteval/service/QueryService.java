package com.smec.eis.example.springbooteval.service;

import com.querydsl.core.types.EntityPath;
import com.querydsl.core.types.Predicate;

import java.util.List;

public interface QueryService {

    <T> List<T> query(EntityPath<T> from, Predicate predicate);

    <T> List<T> query(EntityPath<T> from, Predicate predicate, int offset, int limit);

}
