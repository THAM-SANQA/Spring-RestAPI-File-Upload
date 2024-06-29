package com.enviro.assessment.grad001.thamsanqandaba.logging;

/**
 * Request and Response Logger
 * Author: thamsanqa 2024
 **/

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class RequestResponseLogger extends OncePerRequestFilter {

    private static final Logger logger = LoggerFactory.getLogger(RequestResponseLogger.class);

    // Log incoming request and outgoing response
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        logger.info("Incoming request data: {} {}", request.getMethod(), request.getRequestURI());

        filterChain.doFilter(request, response);

        logger.info("Outgoing response status: {}", response.getContentType());
    }
}