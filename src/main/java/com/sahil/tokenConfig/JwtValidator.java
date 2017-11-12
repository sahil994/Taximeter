package com.sahil.tokenConfig;

import com.sahil.services.ResponseUserModel;
import com.sahil.tokenConfig.tokenmodel.UserTokenModel;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.apache.commons.logging.Log;
import org.springframework.stereotype.Component;

@Component
public class JwtValidator {


    private String secret = "youtube";

    public UserTokenModel validate(String token) {

        UserTokenModel jwtUser = null;

        try {


            Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
            System.out.println("username"+claims.getSubject()+">>"+claims.get("email"));
            jwtUser = new UserTokenModel();
            jwtUser.setEmail(claims.getSubject());
            jwtUser.setUsername(""+claims.get("username"));
        } catch (Exception e) {


            System.out.print(e.getMessage());
        }

        return jwtUser;
    }
}
