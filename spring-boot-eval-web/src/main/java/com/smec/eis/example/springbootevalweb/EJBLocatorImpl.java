package com.smec.eis.example.springbootevalweb;

import org.springframework.stereotype.Component;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

@Component
public class EJBLocatorImpl implements EJBLocator {

    @Override
    public <T> T getEJB(Class<T> tClass) throws NamingException {
        Context ctx = new InitialContext();
        T ejb = (T) ctx.lookup("java:global/spring-boot-app/spring-boot-eval-service-impl/" + tClass.getSimpleName() + "Bean");
        return ejb;
    }
}
