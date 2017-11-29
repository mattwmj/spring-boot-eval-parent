package com.smec.eis.example.springbooteval.service.impl;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class EntityManagerFactoryProducer {

    @PersistenceContext(unitName = "PRIMARY_PU")
    private EntityManager primaryEM;

    @Produces
    @PrimaryEM
    @ApplicationScoped
    public EntityManager createEntityManager() {
        return primaryEM;
    }

    public void close(@Disposes @PrimaryEM EntityManager entityManager) {
        primaryEM.close();
    }

    @PersistenceContext(unitName = "SECONDARY_PU")
    private EntityManager secondaryEM;

    @Produces
    @SecondaryEM
    @ApplicationScoped
    public EntityManager createSecondaryEntityManager() {
        return secondaryEM;
    }

    public void closeSecondary(@Disposes @SecondaryEM EntityManager entityManager) {
        entityManager.close();
    }
}
