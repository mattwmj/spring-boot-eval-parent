package com.smec.eis.example.springbootevalweb;

import org.springframework.security.web.util.matcher.RegexRequestMatcher;

import javax.servlet.http.HttpServletRequest;

public class RequireCsrfProtectionMatcher implements org.springframework.security.web.util.matcher.RequestMatcher {
    //    private Pattern allowedMethods = Pattern.compile("^(GET|HEAD|TRACE|OPTIONS|POST)$");
    private RegexRequestMatcher apiMatcher = new RegexRequestMatcher("/public/.*", null);

    @Override
    public boolean matches(HttpServletRequest request) {

        // No CSRF due to allowedMethod
//        if (allowedMethods.matcher(request.getMethod()).matches())
//            return false;

        // No CSRF due to api call
        if (apiMatcher.matches(request))
            return false;

        // CSRF for everything else that is not an API call or an allowedMethod
        return true;
    }
}
