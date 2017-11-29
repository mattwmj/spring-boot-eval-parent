package com.smec.eis.example.springbooteval.service.impl;

import org.apache.deltaspike.data.api.EntityManagerResolver;

import javax.inject.Inject;
import javax.persistence.EntityManager;

public class PrimaryEmResolver implements EntityManagerResolver {

    @Inject
    @PrimaryEM
    private EntityManager em;

    @Override
    public EntityManager resolveEntityManager() {
        return em;
    }
}
