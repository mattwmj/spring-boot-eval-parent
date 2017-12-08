/*
 * Copyright 2017 Vincenzo De Notaris
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License. 
 */

package com.smec.eis.example.springbootevalweb;

import com.smec.eis.example.springbooteval.service.HRService;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import weblogic.security.Security;

import javax.security.auth.Subject;
import java.security.AccessController;
import java.security.Principal;


@Controller
@Lazy
public class LandingController {

    @EJBClient
    private HRService hrService;

    @RequestMapping("/landing")
    public String landing(Model model, Principal principal) {
        StringBuilder builder = new StringBuilder();
        builder.append("Principal: ").append(principal.getName()).append(" ");
        builder.append("EJB SessionContext: ").append(hrService.whoAmI()).append(" ");
        Subject subject = Subject.getSubject(AccessController.getContext());
        builder.append("AccessController Subject: ").append(subject != null ? subject.toString() : null).append(" ");
        Subject wlsSubject = Security.getCurrentSubject();
        builder.append("WLS Subject: ").append(wlsSubject != null ? wlsSubject.toString() : null).append(" ");
        model.addAttribute("username", builder.toString());
        return "landing";
    }

}
