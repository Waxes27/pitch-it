package com.pitchIt.pitchIt.config.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.HttpRequestResponseHolder;
import org.springframework.security.web.context.SecurityContextRepository;

public class CustomSecurityContextRepository implements SecurityContextRepository {
    
    private ThreadLocal<SecurityContext> contextHolder = new ThreadLocal<>();

    @Override
    public SecurityContext loadContext(HttpRequestResponseHolder requestResponseHolder) {
        SecurityContext context = contextHolder.get();
        if (context == null) {
            context = SecurityContextHolder.createEmptyContext();
            contextHolder.set(context);
        }
        return context;
    }

    @Override
    public void saveContext(SecurityContext context, HttpServletRequest request, HttpServletResponse response) {
        contextHolder.set(context);
    }

    @Override
    public boolean containsContext(HttpServletRequest request) {
        return contextHolder.get() != null;        
    } 
}
