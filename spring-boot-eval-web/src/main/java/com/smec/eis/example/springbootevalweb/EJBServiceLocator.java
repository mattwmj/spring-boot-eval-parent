package com.smec.eis.example.springbootevalweb;

import java.security.Principal;

public interface EJBServiceLocator {

    <T> T getService(Class<T> serviceInterfaceClass);

    <T> T getService(Class<T> serviceInterfaceClass, Principal principal);
}
