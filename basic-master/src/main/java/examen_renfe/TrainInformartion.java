
package examen_renfe;

import static examen_renfe.Parametros.horarios;
import static examen_renfe.Parametros.horarioFiltrado;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.Map;

@Path("/user")
public class TrainInformartion {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    //@Path("/{origen}/{destino}")
    public Map getInformation(/*@PathParam("origen")String origen, @PathParam("destino") String destino*/ Train newTrain){ 
        String origen = newTrain.getOrigen();
        String destino = newTrain.getDestino();
        Parametros.idf.set(0);
        horarioFiltrado.clear();
        for(int i=1; i<=horarios.size(); i++){
            if(horarios.get(i).getOrigen().equals(origen) && horarios.get(i).getDestino().equals(destino)){
                horarioFiltrado.put(Parametros.idf.incrementAndGet(), horarios.get(i));
            }     
        }
        return horarioFiltrado;
    }
}
