package com.smec.eis.example.springbooteval.service;

import com.smec.eis.example.springbooteval.model.TechDoc;

import javax.ejb.Local;
import javax.ejb.Remote;

@Remote
@Local
public interface TechDocService extends QueryService<TechDoc> {
}
