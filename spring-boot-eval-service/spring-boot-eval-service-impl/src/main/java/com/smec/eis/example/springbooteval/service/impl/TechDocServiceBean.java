package com.smec.eis.example.springbooteval.service.impl;

import com.smec.eis.example.springbooteval.model.TechDoc;
import com.smec.eis.example.springbooteval.service.QueryDslSupport;
import com.smec.eis.example.springbooteval.service.TechDocService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class TechDocServiceBean implements TechDocService {

    @Inject
    private TechDocRepository techDocRepository;

    public List<TechDoc> findTechDocCodeLike(String code, int offset, int limit) {
        List<TechDoc> resultList = techDocRepository.findByCodeLike(code, offset, limit);
        return resultList;
    }
}
