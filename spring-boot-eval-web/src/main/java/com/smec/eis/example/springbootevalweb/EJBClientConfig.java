package com.smec.eis.example.springbootevalweb;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EJBClientConfig {

    @Bean
    public EJBClientBeanFactoryPostProcessor autowireCandidateResolverConfigurer() {
        EJBClientBeanFactoryPostProcessor bean = new EJBClientBeanFactoryPostProcessor();
        bean.setAutowireCandidateResolver(new EJBClientAutowiredCandidateResolver());
        return bean;
    }

}
