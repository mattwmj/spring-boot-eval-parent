package com.smec.eis.example.springbooteval.service.impl;

import org.apache.deltaspike.data.api.EntityManagerResolver;

import javax.inject.Inject;
import javax.persistence.EntityManager;

public class SecondaryEmResolver implements EntityManagerResolver {

    @Inject
    @SecondaryEM
    private EntityManager em;

    @Override
    public EntityManager resolveEntityManager() {
        return em;
    }
}
