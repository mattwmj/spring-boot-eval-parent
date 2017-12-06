package com.smec.eis.example.springbootevalweb;

public interface EJBServiceLocator {

    <T> T getService(Class<T> serviceInterfaceClass);

}
