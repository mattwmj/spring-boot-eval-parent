package com.smec.eis.example.springbootevalweb;

import org.springframework.stereotype.Component;
import weblogic.security.Security;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.security.auth.Subject;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.security.AccessController;
import java.security.PrivilegedExceptionAction;

@Component
public class EJBServiceLocatorImpl implements EJBServiceLocator {

    @Override
    public <T> T getService(Class<T> serviceInterfaceClass) {
        try {
            Context ctx = new InitialContext();
            T ejb = (T) ctx.lookup("java:global/spring-boot-app/spring-boot-eval-service-impl/" + serviceInterfaceClass.getSimpleName() + "Bean");
            EJBServiceInvocationHandler handler = new EJBServiceInvocationHandler(ejb);
            Object proxy =
                    Proxy.newProxyInstance(ejb.getClass().getClassLoader(), ejb.getClass().getInterfaces(), handler);
            return (T) proxy;
        } catch (NamingException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    class EJBServiceInvocationHandler implements InvocationHandler {

        private final Object stub;

        public EJBServiceInvocationHandler(Object ejb) {
            this.stub = ejb;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            Subject subject = Subject.getSubject(AccessController.getContext());
            Object methodReturn;
            if (subject != null) {
                methodReturn = Security.runAs(subject, new PrivilegedExceptionAction() {
                    public Object run() throws Exception {
                        return method.invoke(stub, args);
                    }
                });
            } else {
                methodReturn = method.invoke(stub, args);
            }
            return methodReturn;
        }
    }
}
