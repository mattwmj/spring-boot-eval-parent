package com.smec.eis.example.springbootevalweb;

import com.smec.eis.example.springbooteval.service.WebInfraService;
import org.springframework.security.access.vote.RoleVoter;
import org.springframework.security.authentication.jaas.AuthorityGranter;
import org.springframework.stereotype.Component;
import weblogic.security.spi.WLSUser;

import java.security.Principal;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Component
public class RoleGranter implements AuthorityGranter {

    @EJBClient
    WebInfraService roleService;

    private String rolePrefix = "ROLE_";

    public Set<String> grant(Principal principal) {
        if (principal != null && WLSUser.class.isAssignableFrom(principal.getClass())) {
            Set<String> userRoles = roleService.getUserRoleNames(principal.getName());
            HashSet<String> prefixedSet = new HashSet<>();
            for (String role : userRoles) {
                prefixedSet.add(rolePrefix + role);// see RoleVoter
            }
            return prefixedSet;
        } else {
            return Collections.emptySet();
        }
    }
}
