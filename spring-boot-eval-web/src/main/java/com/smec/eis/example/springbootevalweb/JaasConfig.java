package com.smec.eis.example.springbootevalweb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.jaas.AuthorityGranter;
import org.springframework.security.authentication.jaas.DefaultJaasAuthenticationProvider;
import org.springframework.security.authentication.jaas.memory.InMemoryConfiguration;

import javax.security.auth.login.AppConfigurationEntry;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class JaasConfig {

    @Autowired
    RoleGranter roleGranter;

    @Bean
    public DefaultJaasAuthenticationProvider jaasAuthProvider() {
        DefaultJaasAuthenticationProvider jaasAuthProvider = new DefaultJaasAuthenticationProvider();
        Map<String, ?> options = new HashMap();
        AppConfigurationEntry entry = new AppConfigurationEntry("weblogic.security.auth.login.UsernamePasswordLoginModule", AppConfigurationEntry.LoginModuleControlFlag.REQUIRED, options);
        AppConfigurationEntry[] appConfigurationEntries = new AppConfigurationEntry[]{entry};
        Map<String, AppConfigurationEntry[]> defaultConfigurations = new HashMap<>();
        defaultConfigurations.put("SPRINGSECURITY", appConfigurationEntries);
        InMemoryConfiguration configuration = new InMemoryConfiguration(defaultConfigurations);
        jaasAuthProvider.setConfiguration(configuration);
        AuthorityGranter[] roleGranters = new AuthorityGranter[]{roleGranter};
        jaasAuthProvider.setAuthorityGranters(roleGranters);
        return jaasAuthProvider;
    }

}
