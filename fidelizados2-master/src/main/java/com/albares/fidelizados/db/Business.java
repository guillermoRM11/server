
package com.albares.fidelizados.db;

import com.albares.fidelizados.utils.Db;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

@JsonInclude(Include.NON_NULL)
public class Business {
    private Integer id;
    private String name;
    private String address;
    private String vat;
    private String phone;
    private Integer ratio_euro_point;
    private Integer freePrizes;
    private Login login;

    //Fuera de BBDD
    String token;
    
    public Business() {
    }

    public void getIdAndNamebyLogin(Db myDb) throws SQLException{
        PreparedStatement ps = myDb.prepareStatement(
                    "SELECT id,name FROM business WHERE  login_id = ?;"
            );
        ps.setInt(1, this.getLogin().getId());
        
        ResultSet rs = myDb.executeQuery(ps);
        if(rs.next()){
            this.setId(rs.getInt("id"));
            this.setName(rs.getString("name"));
        }
    }
    
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getVat() {
        return vat;
    }

    public void setVat(String vat) {
        this.vat = vat;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getRatio_euro_point() {
        return ratio_euro_point;
    }

    public void setRatio_euro_point(Integer ratio_euro_point) {
        this.ratio_euro_point = ratio_euro_point;
    }

    public Integer getFreePrizes() {
        return freePrizes;
    }

    public void setFreePrizes(Integer freePrizes) {
        this.freePrizes = freePrizes;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void insert_DB(Db myDb) throws SQLException, Exception {
                PreparedStatement ps = myDb.prepareStatement(
                    "INSERT INTO business (name,vat,address,phone,ratio_euro_point,login_id) VALUES (?,?,?,?,?,?) RETURNING id;"
            );
        ps.setString(1, this.getName());
        ps.setString(2, this.getVat());
        ps.setString(3, this.getAddress());
        ps.setString(4, this.getPhone());
        ps.setInt(5, this.getRatio_euro_point());
        ps.setInt(6, this.getLogin().getId());
        
        ResultSet rs = myDb.executeQuery(ps);
        if(rs.next()){
            this.setId(rs.getInt("id"));
        }else{
            throw new Exception();
        }
    }
    
    
}
