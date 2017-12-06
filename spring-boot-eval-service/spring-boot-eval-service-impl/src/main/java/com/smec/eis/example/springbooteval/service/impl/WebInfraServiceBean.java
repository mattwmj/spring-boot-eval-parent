package com.smec.eis.example.springbooteval.service.impl;

import com.smec.eis.example.springbooteval.service.WebInfraService;

import javax.annotation.security.RunAs;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Stateless
@RunAs(value = "WebInfra")
public class WebInfraServiceBean implements WebInfraService {

    @EJB(name = "RoleService", mappedName = "RoleServiceBean")
    private com.smec.sis.infra.identity.service.RoleService roleService;

    @Override
    public Set<String> getUserRoleNames(String userId) {
        String[] userRoleNames = roleService.getUserRoleNames(userId);
        HashSet<String> roleSet = new HashSet<>(Arrays.asList(userRoleNames));
        return roleSet;
    }
}
