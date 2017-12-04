package com.smec.eis.example.springbootevalweb;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Autowired
@Retention(RetentionPolicy.RUNTIME)
@interface EJBClient {
    boolean remote() default true;
}
