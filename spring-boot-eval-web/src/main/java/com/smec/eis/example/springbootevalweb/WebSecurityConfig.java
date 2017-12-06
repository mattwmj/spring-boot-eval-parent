package com.smec.eis.example.springbootevalweb;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.jaasapi.JaasApiIntegrationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().requireCsrfProtectionMatcher(new RequireCsrfProtectionMatcher())
                .and()
                .addFilter(new JaasApiIntegrationFilter())
                .authorizeRequests()
                .anyRequest().authenticated()
                .antMatchers("/public/**").permitAll()
                .antMatchers("/admin/**").hasRole("Admin")
                .and()
                .formLogin()
                .and()
                .httpBasic();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
        web.debug(true);
    }
}
