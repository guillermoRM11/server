
package examen_renfe;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import java.util.Date;

public final class TokenUtils {
    private static final Algorithm algorithm = Algorithm.HMAC256(SecretoTren.JWT_SECRET);
    private static final JWTVerifier verifier = JWT.require(algorithm)
            .withIssuer(Parametros.PROJECT_NAME)
            .build(); 

    /*static Object checkJWTandGetUserId(String origen, String destino) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/
    
    public TokenUtils() {
    }
    
    public static final String generateToken(int id){
        String token = JWT.create()
                .withIssuer(Parametros.PROJECT_NAME)
                .withClaim("id", id)
                //.withExpiresAt(new Date(System.currentTimeMillis()+Parametros.EXPIRATION_MILLIS))
                .withIssuedAt(new Date())
                .sign(algorithm);
        return token;
    }
    
    public static final Integer checkJWTandGetUserId(String token){
        try{
            DecodedJWT jwt = verifier.verify(token);
            return jwt.getClaim("id").asInt();
        }catch (Exception ex) {
            /*Avisar con bandera roja*/
            return -1;
        }
    }
}
    
    
    

