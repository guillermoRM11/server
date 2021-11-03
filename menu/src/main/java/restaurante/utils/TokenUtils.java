
package restaurante.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import java.util.Date;


public final class TokenUtils {
    private static final Algorithm algorithm = Algorithm.HMAC256(Secret.JWT_SECRET);
    private static final JWTVerifier verifier = JWT.require(algorithm)
            .withIssuer(Parameters.PROJECT_NAME)
            .build(); 
    
    public TokenUtils() {
    }
    
    /*public static final String generateToken(int id){
        String token = JWT.create()
                .withIssuer(Parameters.PROJECT_NAME)
                .withClaim("id", id)
                //.withExpiresAt(new Date(System.currentTimeMillis()+Parametros.EXPIRATION_MILLIS))
                .withIssuedAt(new Date())
                .sign(algorithm);
        return token;
    }*/
    
    public static final Boolean checkJWTandGetUserId(String token){
        try{
            DecodedJWT jwt = verifier.verify(token);
            return true;
        }catch (Exception ex) {
            /*Avisar con bandera roja*/
            return false;
        }
    }
}
