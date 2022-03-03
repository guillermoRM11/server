
package com.albares.fidelizados.api;

import com.albares.fidelizados.db.User;
import com.albares.fidelizados.utils.FileCoded;
import com.albares.fidelizados.utils.GenericData;
import com.albares.fidelizados.utils.Image;
import com.albares.fidelizados.utils.Response;
import com.albares.fidelizados.utils.ResponseCodes;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.OPTIONS;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.io.IOException;
import java.io.InputStream;
import java.security.NoSuchAlgorithmException;

@Path("/addImage")
public class addImage {
    
  @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/base64") 
    public com.albares.fidelizados.utils.Response addImageBase64(FileCoded ImageEncoded) throws IOException, NoSuchAlgorithmException {
        
        
        Image i = new Image();
        
        i.saveBase64Image(new String(ImageEncoded.getCode()));
        
        return (new Response(ResponseCodes.OK, new GenericData(i)) {});
        
        
    }    
}
