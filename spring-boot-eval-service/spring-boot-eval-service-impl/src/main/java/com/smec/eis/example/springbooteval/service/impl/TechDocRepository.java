package com.smec.eis.example.springbooteval.service.impl;

import com.smec.eis.example.springbooteval.model.TechDoc;
import com.smec.eis.example.springbooteval.service.QueryDslSupport;
import org.apache.deltaspike.data.api.EntityManagerConfig;
import org.apache.deltaspike.data.api.FullEntityRepository;
import org.apache.deltaspike.data.api.Repository;

@Repository
@EntityManagerConfig(entityManagerResolver = PrimaryEmResolver.class)
public interface TechDocRepository extends QueryDslSupport<TechDoc>, FullEntityRepository<TechDoc, Long> {
}
