package com.smec.eis.example.springbooteval.service.impl;

import com.smec.eis.example.springbooteval.model.TechDoc;
import com.smec.eis.example.springbooteval.service.QueryDslSupport;
import org.apache.deltaspike.data.api.*;

import java.util.List;

@Repository
@EntityManagerConfig(entityManagerResolver = PrimaryEmResolver.class)
public interface TechDocRepository extends QueryDslSupport<TechDoc>, FullEntityRepository<TechDoc, Long> {

    List<TechDoc> findByCodeLike(String code, @FirstResult int offset, @MaxResults int limit);

}
