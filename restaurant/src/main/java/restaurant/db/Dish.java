package restaurant.db;

import restaurant.utils.Db;
import restaurant.utils.JWTUtils;
import static restaurant.utils.SHAUtils.sha256;
import restaurant.utils.Secrets;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Dish {

    private String name;
    private Integer price;
    private Integer type;

    
    public Dish() {
    }

    public Dish(String name, Integer price, Integer type) {
        this.name = name;
        this.price = price;
        this.type = type;
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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Dish{" + "name=" + name + ", price=" + price + ", type=" + type + '}';
    }
    
    
    public Dish insertDishes_DB(Db myDb) throws SQLException, NoSuchAlgorithmException {
        PreparedStatement ps = myDb.prepareStatement(
                "INSERT INTO dishes (name, price, type) VALUES (?, ?, ?);"
        );
        ps.setString(1, this.getName());
        ps.setInt(2, this.getPrice());
        ps.setInt(3, this.getType());
        ps.executeUpdate();
        
        return this;
    }
    
    
    public Dish selectDishes_DB(Db myDb) throws SQLException {        
        PreparedStatement ps = myDb.prepareStatement(
                "SELECT name,price FROM dishes WHERE type =?;"
        );
        ps.setInt(1, this.getType());        
        ResultSet rs = myDb.executeQuery(ps);
        rs.next();
        this.setName(rs.getString(1));
        this.setPrice(rs.getInt(2));
        Dish newDish = new Dish();
        newDish.setName(rs.getString(1));
        newDish.setPrice(rs.getInt(2));
        newDish.setType(type);
        return newDish;
        
    }
    
}
