package com.sahil.tokenConfig;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtAuthneticationTokenFilter extends AbstractAuthenticationProcessingFilter {

    public JwtAuthneticationTokenFilter() {
        super("/rest/**");
    }


    @Override
    public Authentication attemptAuthentication(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws AuthenticationException, IOException, ServletException {

        String header = httpServletRequest.getHeader("Authorization");

        System.out.print(""+header);
        if (header == null || !header.startsWith("Token")) {

            throw new RuntimeException("JWT Token is missing");

        }

        String authrozationToken = header.substring(6);

        JwtAuthenticationToken jwtAuthenticationToken = new JwtAuthenticationToken(authrozationToken);

        return getAuthenticationManager().authenticate(jwtAuthenticationToken);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        super.successfulAuthentication(request, response, chain, authResult);

        chain.doFilter(request,response);
    }
}
