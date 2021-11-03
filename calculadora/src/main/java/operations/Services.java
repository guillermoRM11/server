
package operations;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/service")
public class Services {
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public String calc (Operations newOperations){   
        switch (newOperations.getSign()) {
            case "+":
                return("El resultado es: "+ (newOperations.getNumber1()+newOperations.getNumber2()));
            case "-":
                return("El resultado es: "+ (newOperations.getNumber1()-newOperations.getNumber2()));
            case "*":
                return("El resultado es: "+ (newOperations.getNumber1()*newOperations.getNumber2()));
            case "/":
                return("El resultado es: "+ (newOperations.getNumber1()/newOperations.getNumber2()));
            default:
                return("La operacion introducida no es correcta.");
        }
    }
    
}
