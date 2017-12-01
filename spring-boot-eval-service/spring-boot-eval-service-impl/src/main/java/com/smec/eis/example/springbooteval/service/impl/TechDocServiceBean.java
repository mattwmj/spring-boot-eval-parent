package com.smec.eis.example.springbooteval.service.impl;

import com.smec.eis.example.springbooteval.model.TechDoc;
import com.smec.eis.example.springbooteval.service.AbstractQueryService;
import com.smec.eis.example.springbooteval.service.QueryDslSupport;
import com.smec.eis.example.springbooteval.service.TechDocService;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class TechDocServiceBean extends AbstractQueryService<TechDoc> implements TechDocService {

    @Inject
    private TechDocRepository techDocRepository;

    @Override
    public QueryDslSupport<TechDoc> getQueryDslSupport() {
        return techDocRepository;
    }
}
