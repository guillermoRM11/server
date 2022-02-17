
package marsattack.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.OPTIONS;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.ResponseBuilder;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.List;
import marsattack.db.Score;
import marsattack.utils.Db;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Path("/addRecord")
public class addScore {
    ResponseBuilder r = Response.ok()
                           .header("Access-Control-Allow-Origin","*")
                           .header("Access-Control-Allow-Methods","OPTIONS,POST, GET")
                           .header("Access-Control-Allow-Headers","Content-Type, Authorization");

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @SuppressWarnings("empty-statement")
    public Response addScore(Score score) throws Exception{  
        try{
            Db myDb = new Db();
            
            myDb.connect();
            score.insertScores_DB(myDb);
            List records=Score.selectScores_DB(myDb);
            myDb.disconnect();
            
            r.entity(records);
            
        }catch(NoSuchAlgorithmException | SQLException e){ 
        }
        return r.build();
    } 
    
    @OPTIONS
    public Response doOptions(){
        return r.build();
    }
}
