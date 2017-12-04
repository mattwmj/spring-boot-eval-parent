package com.smec.eis.example.springbootevalweb;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AutowireCandidateResolver;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

public class EJBClientBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    private AutowireCandidateResolver autowireCandidateResolver;

    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        DefaultListableBeanFactory bf = (DefaultListableBeanFactory) beanFactory;
        bf.setAutowireCandidateResolver(autowireCandidateResolver);
    }

    public AutowireCandidateResolver getAutowireCandidateResolver() {
        return autowireCandidateResolver;
    }

    public void setAutowireCandidateResolver(AutowireCandidateResolver autowireCandidateResolver) {
        this.autowireCandidateResolver = autowireCandidateResolver;
    }

}
