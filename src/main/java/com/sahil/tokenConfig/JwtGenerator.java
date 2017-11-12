package com.sahil.tokenConfig;

import com.sahil.tokenConfig.tokenmodel.UserTokenModel;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

@Component
public class JwtGenerator {
    public String generate(UserTokenModel userTokenModel) {

        Claims claims = Jwts.claims().setSubject(userTokenModel.getEmail());
        claims.put("username", userTokenModel.getUsername());
        return Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.HS512, "youtube").compact();
    }
}
