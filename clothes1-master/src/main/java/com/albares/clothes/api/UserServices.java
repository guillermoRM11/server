
package com.albares.clothes.api;

import com.albares.clothes.db.Product;
import com.albares.clothes.utils.Db;
import com.albares.clothes.utils.Response;
import com.albares.clothes.utils.ResponseCodes;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.sql.SQLException;
import java.util.List;

@Path("/user")
public class UserServices {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response sellProduct(Product product){
        try{
            Db myDb = new Db();
            Response r = new Response();
            
            myDb.connect();
            if(product.getQuantity()<Product.selectStock_DB(myDb, product.getId())){
                Product.sellProducts(myDb, product.getId(), product.getQuantity());
                r.setResponseCode(ResponseCodes.OK);
            }
            else{
                r.setResponseCode(ResponseCodes.INCORRECT);
            }
            myDb.disconnect();
            return r;
            
        }catch(SQLException e){
            Response r = new Response();
            r.setResponseCode(ResponseCodes.ERROR);
            return r; 
        }
        
        
    }
    
    @GET
    @Path("/{gender}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProductsByGender(@PathParam("gender") Integer gender){
        try{
            Db myDb = new Db();

            myDb.connect();
            List <Product> allProducts = Product.selectProductsByGender_DB(myDb, gender);
            myDb.disconnect();
            Response r = new Response();
            r.setProducts(allProducts);
            r.setResponseCode(ResponseCodes.OK);
            return r;
            
        }catch(SQLException e){
            Response r = new Response();
            r.setResponseCode(ResponseCodes.ERROR);
            return r; 
        }
    }
    
}
