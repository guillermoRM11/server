package com.albares.fidelizados.db;

import com.albares.fidelizados.utils.Db;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

@JsonInclude(Include.NON_NULL)
public class User {
    
    private Integer id;
    private String name;
    private Integer gender;
    private String code;
    private Login login;
    private Long birthDate;
    
    
    //Fuera de BBDD
    String token;
    

    public User() {
    }

    public void getIdAndNamebyLogin(Db myDb) throws SQLException{
        PreparedStatement ps = myDb.prepareStatement(
                    "SELECT id,name FROM users WHERE  login_id = ?;"
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

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public Long getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Long birthDate) {
        this.birthDate = birthDate;
    }



    public void insert_DB(Db myDb) throws SQLException, Exception {
        PreparedStatement ps = myDb.prepareStatement(
                    "INSERT INTO users (name,birth_date,gender,login_id) VALUES (?,?,?,?) RETURNING id;"
            );
        ps.setString(1, this.getName());
        ps.setTimestamp(2, new Timestamp(this.getBirthDate()));
        ps.setInt(3, this.getGender());
        ps.setInt(4, this.getLogin().getId());
        
        ResultSet rs = myDb.executeQuery(ps);
        if(rs.next()){
            this.setId(rs.getInt("id"));
        }else{
            throw new Exception();
        }
    }
    
    
    
    
    
}
