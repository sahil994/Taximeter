package com.sahil.tokenConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.Collections;


@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
@Configuration
public class JwtSecurityConfiggg extends WebSecurityConfigurerAdapter {

    @Autowired
    private JwtAuthenticationProvider authprovide;

    @Autowired
    private JwtAuthenticationEntryPoint entryPoint;

    @Bean
    public JwtAuthneticationTokenFilter authenticationTokenFilter() {

        JwtAuthneticationTokenFilter jwtAuthneticationToken = new JwtAuthneticationTokenFilter();

        jwtAuthneticationToken.setAuthenticationManager(authenticationManager());

        jwtAuthneticationToken.setAuthenticationSuccessHandler(new JwtSucessHander());

        return jwtAuthneticationToken;
    }

    @Bean
    public AuthenticationManager authenticationManager() {

        return new ProviderManager(Collections.singletonList(authprovide));

    }

    @Override
    protected void configure(HttpSecurity auth) throws Exception {
        super.configure(auth);

        auth.csrf().disable().authorizeRequests().anyRequest().permitAll()
                .antMatchers(HttpMethod.GET,"\"/*.html\"").permitAll().antMatchers("**/rest/**").authenticated().and().exceptionHandling().authenticationEntryPoint(entryPoint).and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        auth.addFilterBefore(authenticationTokenFilter(), UsernamePasswordAuthenticationFilter.class);

        auth.headers().cacheControl();

    }




}
