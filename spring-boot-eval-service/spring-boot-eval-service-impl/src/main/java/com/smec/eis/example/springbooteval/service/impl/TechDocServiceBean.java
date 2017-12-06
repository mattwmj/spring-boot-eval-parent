package com.smec.eis.example.springbooteval.service.impl;

import com.smec.eis.example.springbooteval.model.TechDoc;
import com.smec.eis.example.springbooteval.service.TechDocService;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.security.Principal;
import java.util.List;

@Stateless
public class TechDocServiceBean implements TechDocService {

    @Inject
    private TechDocRepository techDocRepository;
    @Resource
    private SessionContext sessionContext;

    public List<TechDoc> findTechDocCodeLike(String code, int offset, int limit) {
        Principal caller = sessionContext.getCallerPrincipal();
        System.out.println(caller.getName());
        List<TechDoc> resultList = techDocRepository.findByCodeLike(code, offset, limit);
        return resultList;
    }
}
