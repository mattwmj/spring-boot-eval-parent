package com.smec.eis.example.springbootevalweb;

import com.smec.eis.example.springbooteval.model.TechDoc;
import com.smec.eis.example.springbooteval.service.TechDocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.naming.NamingException;
import java.util.List;

@RestController
public class TechDocController {

    @Autowired
    private EJBLocator ejbLocator;
    private TechDocService techDocService = null;

    private synchronized TechDocService getTechDocService() {
        if (techDocService == null) {
            try {
                techDocService = ejbLocator.getEJB(TechDocService.class);
            } catch (NamingException e) {
                e.printStackTrace();
            }
        }
        return techDocService;
    }

    @RequestMapping(value = "/tecDoc/{code}", method = RequestMethod.GET)
    public @ResponseBody
    List<TechDoc> findByCodeLikePath(@PathVariable String code, @RequestParam(value = "offset", defaultValue = "0") int offset, @RequestParam(value = "limit", defaultValue = "50") int limit) {
        List<TechDoc> resultList = getTechDocService().findTechDocCodeLike(code, offset, limit);
        return resultList;
    }

}
