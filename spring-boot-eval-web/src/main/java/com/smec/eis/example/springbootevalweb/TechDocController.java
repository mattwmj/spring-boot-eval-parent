package com.smec.eis.example.springbootevalweb;

import com.querydsl.core.types.EntityPath;
import com.querydsl.core.types.Predicate;
import com.smec.eis.example.springbooteval.model.QTechDoc;
import com.smec.eis.example.springbooteval.model.TechDoc;
import com.smec.eis.example.springbooteval.service.QueryService;
import com.smec.eis.example.springbooteval.service.TechDocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.naming.NamingException;
import java.util.List;

@RestController
public class TechDocController {

    @Autowired
    private EJBLocator ejbLocator;
    private QueryService queryService = null;

    private synchronized QueryService getQueryService() {
        if (queryService == null) {
            try {
                queryService = ejbLocator.getEJB(TechDocService.class);
            } catch (NamingException e) {
                e.printStackTrace();
            }
        }
        return queryService;
    }

    @RequestMapping(value = "/tecDoc/{code}", method = RequestMethod.GET)
    public @ResponseBody
    List<TechDoc> findByCodeLikePath(@PathVariable String code, @RequestParam(value = "offset", defaultValue = "0") long offset, @RequestParam(value = "limit", defaultValue = "50") long limit) {
        EntityPath<TechDoc> from = QTechDoc.techDoc;
        Predicate predicate = QTechDoc.techDoc.code.like(code);
        List<TechDoc> resultList = getQueryService().query(from, predicate, offset, limit);
        return resultList;
    }

}
