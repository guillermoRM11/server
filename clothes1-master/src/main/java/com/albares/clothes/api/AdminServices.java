
package com.albares.clothes.api;

import com.albares.clothes.db.Product;
import com.albares.clothes.utils.Db;
import com.albares.clothes.utils.Response;
import com.albares.clothes.utils.ResponseCodes;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.List;

@Path("/admin")
public class AdminServices {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addProduct(Product newProduct) throws SQLException, NoSuchAlgorithmException{
        try{
            Db myDb = new Db();

            myDb.connect();
            newProduct.insertProducts_DB(myDb);
            myDb.disconnect();
            Response r = new Response();
            r.setResponseCode(ResponseCodes.OK);
            return r;
            
        }catch(SQLException e){
            Response r = new Response();
            r.setResponseCode(ResponseCodes.ERROR);
            return r; 
        }
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProducts(){
        try{
            Db myDb = new Db();

            myDb.connect();
            List <Product> allProducts = Product.selectProducts_DB(myDb);
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
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response editProduct(Product product) throws SQLException{
        try{
            Db myDb = new Db();

            myDb.connect();
            product.updateProduct(myDb);
            myDb.disconnect();
            Response r = new Response();
            r.setResponseCode(ResponseCodes.OK);
            return r;
            
        }catch(SQLException e){
            Response r = new Response();
            r.setResponseCode(ResponseCodes.ERROR);
            return r; 
        }
    }
    
}

            