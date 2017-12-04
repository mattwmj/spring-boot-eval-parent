package com.smec.eis.example.springbootevalweb;

import org.springframework.beans.factory.config.DependencyDescriptor;
import org.springframework.beans.factory.support.SimpleAutowireCandidateResolver;

import javax.naming.NamingException;

public class EJBClientAutowiredCandidateResolver extends SimpleAutowireCandidateResolver {

    EJBLocator ejbLocator;

    public EJBClientAutowiredCandidateResolver() {
        this.ejbLocator = new EJBLocatorImpl();
    }

    @Override
    public Object getSuggestedValue(DependencyDescriptor descriptor) {
        EJBClient ejbClientAnno = descriptor.getAnnotation(EJBClient.class);
        if (ejbClientAnno != null) {
            Class<?> ejbInterface = descriptor.getDependencyType();
            try {
                Object value = ejbLocator.getEJB(ejbInterface);
                return value;
            } catch (NamingException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
        return super.getSuggestedValue(descriptor);
    }
}
