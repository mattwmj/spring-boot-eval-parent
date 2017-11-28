package com.smec.eis.example.springbootevalweb;

import javax.naming.NamingException;

public interface EJBLocator {

    <T> T getEJB(Class<T> tClass) throws NamingException;

}
