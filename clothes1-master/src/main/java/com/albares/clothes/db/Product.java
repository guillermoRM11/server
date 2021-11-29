
package com.albares.clothes.db;

import com.albares.clothes.utils.Db;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Product {
    
    private Integer id;
    private String name;
    private Integer price;
    private Integer stock;
    private Integer gender;
    
    private Integer quantity;
    
    public Product(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    
    

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", name=" + name + ", price=" + price + ", stock=" + stock + ", gender=" + gender + '}';
    }
    
    
    public void insertProducts_DB(Db myDb) throws SQLException, NoSuchAlgorithmException {
        PreparedStatement ps = myDb.prepareStatement(
                "INSERT INTO products (id, name, price, stock, gender) VALUES (?, ?, ?, ?, ?);"
        );
        ps.setInt(1, this.getId());
        ps.setString(2, this.getName());
        ps.setInt(3, this.getPrice());
        ps.setInt(4, this.getStock());
        ps.setInt(5, this.getStock());
        
        myDb.executUpdate(ps);
    }
    
    public static List selectProducts_DB(Db myDb) throws SQLException{
        PreparedStatement ps = myDb.prepareStatement(
                "SELECT id, name, price, stock, gender FROM products;"
        );
        ResultSet rs = myDb.executeQuery(ps);
        
        List <Product> myProducts = new ArrayList();
        while(rs.next()){
            Product product = new Product();
            product.setId(rs.getInt(1));
            product.setName(rs.getString(2));
            product.setPrice(rs.getInt(3));
            product.setStock(rs.getInt(4));
            product.setGender(rs.getInt(5));
            myProducts.add(product);
        }
        return myProducts;
    }
    
    public static void sellProducts(Db myDb, Integer id, Integer quantity) throws SQLException{
        PreparedStatement ps = myDb.prepareStatement(
                "UPDATE products SET stock = ? WHERE id = ?;"
        );
        ps.setInt(1, Product.selectStock_DB(myDb, id) - quantity);
        ps.setInt(2, id);
        
        myDb.executUpdate(ps);
    }
    
    public static Integer selectStock_DB(Db myDb, Integer id) throws SQLException {        
        PreparedStatement ps = myDb.prepareStatement(
                "SELECT stock FROM products WHERE id = ?;"
        );
        ps.setInt(1, id);
        ResultSet rs = myDb.executeQuery(ps);
        
        rs.next();
        Integer stock= rs.getInt(1);
        return stock;
        
    }
    
    public static List selectProductsByGender_DB(Db myDb, Integer gender) throws SQLException{
        PreparedStatement ps = myDb.prepareStatement(
                "SELECT id, name, price, stock, gender FROM products WHERE gender = ?;"
        );
        
        ps.setInt(1, gender);
        ResultSet rs = myDb.executeQuery(ps);
        
        List <Product> myProducts = new ArrayList();
        while(rs.next()){
            Product product = new Product();
            product.setId(rs.getInt(1));
            product.setName(rs.getString(2));
            product.setPrice(rs.getInt(3));
            product.setStock(rs.getInt(4));
            product.setGender(rs.getInt(5));
            myProducts.add(product);
        }
        return myProducts;
    }
    
    public void updateProduct(Db myDb) throws SQLException{
        PreparedStatement ps = myDb.prepareStatement(
                "UPDATE products SET id = ?, name = ?, price = ?, stock = ?, gender = ? WHERE id = ?;"
        );
        ps.setInt(1, this.getId());
        ps.setString(2, this.getName());
        ps.setInt(3, this.getPrice());
        ps.setInt(4, this.getStock());
        ps.setInt(5, this.getGender());
        ps.setInt(6, this.getId());
        
        myDb.executUpdate(ps);
        
    }
}