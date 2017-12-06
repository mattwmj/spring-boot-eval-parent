package com.smec.eis.example.springbooteval.service;

import javax.ejb.Local;
import javax.ejb.Remote;
import java.util.Set;

@Remote
@Local
public interface WebInfraService {

    Set<String> getUserRoleNames(String userId);

}
