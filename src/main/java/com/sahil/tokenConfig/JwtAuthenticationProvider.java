package com.sahil.tokenConfig;

import com.sahil.controller.usercontroller.Constants;
import com.sahil.services.ResponseUserModel;
import com.sahil.tokenConfig.tokenmodel.UserTokenModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JwtAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

    @Autowired
    JwtValidator jwtValidator;

    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) throws AuthenticationException {

    }


    @Override
    public UserDetails retrieveUser(String s, UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) throws AuthenticationException {

        JwtAuthenticationToken jwtAuthenticationToken = (JwtAuthenticationToken) usernamePasswordAuthenticationToken;

        String token = jwtAuthenticationToken.getToken();

        UserTokenModel jwtUser=jwtValidator.validate(token);

        if(jwtUser==null){


            throw new RuntimeException("JWT Token is incorrect");
        }

        System.out.println(""+jwtUser.getUsername()+">>>>"+jwtUser.getEmail());
        Constants.token=token;
        Constants.username=jwtUser.getUsername();
        Constants.email=jwtUser.getEmail();

        List<GrantedAuthority> grantedAuthorityList= AuthorityUtils.commaSeparatedStringToAuthorityList(jwtUser.getEmail());

        return new JwtUserDetail(jwtUser.getEmail(),1,token,grantedAuthorityList);
       }

    @Override
    public boolean supports(Class<?> aClass) {
        return JwtAuthenticationToken.class.isAssignableFrom(aClass);
    }
}
