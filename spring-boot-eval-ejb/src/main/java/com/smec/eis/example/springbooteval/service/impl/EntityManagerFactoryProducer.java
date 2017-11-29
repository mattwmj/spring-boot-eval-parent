package com.smec.eis.example.springbooteval.service.impl;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.*;


public class EntityManagerFactoryProducer {
    
    @Produces
    @ApplicationScoped
    @PrimaryEM
    public EntityManagerFactory createEntityManagerFactory() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PRIMARY_PU");
        return emf;
    }

    @Produces
    @Dependent
    @PrimaryEM
    public EntityManager createEntityManager(@PrimaryEM EntityManagerFactory entityManagerFactory) {
        EntityManager em = entityManagerFactory.createEntityManager();
        return em;
    }

    @Produces
    @ApplicationScoped
    @SecondaryEM
    public EntityManagerFactory createSecondaryEntityManagerFactory() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SECONDARY_PU");
        return emf;
    }

    @Produces
    @Dependent
    @SecondaryEM
    public EntityManager createSecondaryEntityManager(@SecondaryEM EntityManagerFactory entityManagerFactory) {
        EntityManager em = entityManagerFactory.createEntityManager();
        return em;
    }

    public void close(@Disposes @PrimaryEM EntityManager entityManager) {
        entityManager.close();
    }


    public void close(@Disposes @PrimaryEM EntityManagerFactory entityManagerFactory) {
        entityManagerFactory.close();
    }

    public void closeSecondary(@Disposes @SecondaryEM EntityManager entityManager) {
        entityManager.close();
    }

    public void closeSecondary(@Disposes @SecondaryEM EntityManagerFactory entityManagerFactory) {
        entityManagerFactory.close();
    }
}
