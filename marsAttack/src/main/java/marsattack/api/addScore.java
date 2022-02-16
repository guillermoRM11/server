
package marsattack.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import marsattack.db.Score;
import marsattack.utils.Db;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Path("")
public class addScore {
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void addScore(Score score){  
        try{
            Db myDb = new Db();
            
            myDb.connect();
            score.insertScores_DB(myDb);
            myDb.disconnect();
            
        }catch(NoSuchAlgorithmException | SQLException e){ 
        }
    }    
}
