package com.smec.eis.example.springbooteval.service.impl;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactoryProducer {

    @Produces
    @PrimaryEM
    @ApplicationScoped
    public EntityManagerFactory createEntityManagerFactory() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PRIMARY_PU");
        return emf;
    }

    @Produces
    @PrimaryEM
    @ApplicationScoped
    public EntityManager createEntityManager(@PrimaryEM EntityManagerFactory entityManagerFactory) {
        EntityManager em = entityManagerFactory.createEntityManager();
        return em;
    }

    @Produces
    @SecondaryEM
    @ApplicationScoped
    public EntityManagerFactory createSecondaryEntityManagerFactory() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SECONDARY_PU");
        return emf;
    }

    @Produces
    @SecondaryEM
    @ApplicationScoped
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
