
package restautante.test;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import java.util.Date;
import restaurante.utils.Parameters;
import static restaurante.utils.Parameters.id;
import restaurante.utils.Secret;

public class Test {
    public static void main(String[]args){
        Algorithm algorithm = Algorithm.HMAC256(Secret.JWT_SECRET);
        JWTVerifier verifier = JWT.require(algorithm)
        .withIssuer(Parameters.PROJECT_NAME)
        .build(); 
        String token = JWT.create()
            .withIssuer(Parameters.PROJECT_NAME)
            //.withExpiresAt(new Date(System.currentTimeMillis()+Parametros.EXPIRATION_MILLIS))
            .withIssuedAt(new Date())
            .sign(algorithm);
        System.out.println(token);
    }
    
}
