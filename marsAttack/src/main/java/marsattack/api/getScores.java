
package marsattack.api;

import jakarta.ws.rs.OPTIONS;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.ResponseBuilder;
import java.sql.SQLException;
import java.util.List;
import marsattack.db.Score;
import marsattack.utils.Db;



@Path("getRecord") //Hay que especificar que se quiere una ruta aunque no se ponga nada
public class getScores {
    ResponseBuilder r = jakarta.ws.rs.core.Response.ok()
                           .header("Access-Control-Allow-Origin","*")
                           .header("Access-Control-Allow-Methods","OPTIONS,POST, GET")
                           .header("Access-Control-Allow-Headers","Content-Type, Authorization"); 
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response getScores() throws Exception{  
        try{
            Db myDb = new Db();
            
            myDb.connect();           
            List<Score> scoresResponse = Score.selectScores_DB(myDb);
            myDb.disconnect();
            
            r.entity(scoresResponse);
        }catch(SQLException e){
        }
        return r.build();
        
    }
    @OPTIONS
    public Response doOptions(){
        return r.build();
    }
}
