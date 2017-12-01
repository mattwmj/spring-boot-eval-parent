package com.smec.eis.example.springbooteval.service;

import com.smec.eis.example.springbooteval.model.TechDoc;

import javax.ejb.Local;
import javax.ejb.Remote;
import java.util.List;

@Remote
@Local
public interface TechDocService {

    List<TechDoc> findTechDocCodeLike(String code, int offset, int limit);

}
