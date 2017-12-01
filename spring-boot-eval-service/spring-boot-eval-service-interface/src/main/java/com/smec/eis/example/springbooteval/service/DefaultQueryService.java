package com.smec.eis.example.springbooteval.service;

import javax.ejb.Local;
import javax.ejb.Remote;

@Remote
@Local
public interface DefaultQueryService extends QueryService {
}
