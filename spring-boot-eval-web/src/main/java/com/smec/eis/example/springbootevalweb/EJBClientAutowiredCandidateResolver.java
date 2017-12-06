package com.smec.eis.example.springbootevalweb;

import org.springframework.beans.factory.config.DependencyDescriptor;
import org.springframework.context.annotation.ContextAnnotationAutowireCandidateResolver;

public class EJBClientAutowiredCandidateResolver extends ContextAnnotationAutowireCandidateResolver {

    private EJBServiceLocator ejbLocator;

    public EJBClientAutowiredCandidateResolver() {
        this.ejbLocator = new EJBServiceLocatorImpl();
    }

    @Override
    public Object getSuggestedValue(DependencyDescriptor descriptor) {
        EJBClient ejbClientAnno = descriptor.getAnnotation(EJBClient.class);
        if (ejbClientAnno != null) {
            Class<?> ejbInterface = descriptor.getDependencyType();
            Object value = ejbLocator.getService(ejbInterface);
            return value;
        }
        return super.getSuggestedValue(descriptor);
    }
}
