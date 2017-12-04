package com.smec.eis.example.springbootevalweb;

import com.smec.eis.example.springbooteval.model.TechDoc;
import com.smec.eis.example.springbooteval.service.TechDocService;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Lazy
public class TechDocController {

    @EJBClient
    private TechDocService techDocService;

    @RequestMapping(value = "/tecDoc/{code}", method = RequestMethod.GET)
    public @ResponseBody
    List<TechDoc> findByCodeLikePath(@PathVariable String code, @RequestParam(value = "offset", defaultValue = "0") int offset, @RequestParam(value = "limit", defaultValue = "50") int limit) {
        List<TechDoc> resultList = techDocService.findTechDocCodeLike(code, offset, limit);
        return resultList;
    }

}
