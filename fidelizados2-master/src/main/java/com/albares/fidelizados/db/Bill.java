
package com.albares.fidelizados.db;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.util.ArrayList;
import java.util.Date;

@JsonInclude(Include.NON_NULL)
public class Bill {
    private Integer id;
    private Integer price;
    private Date date;
    private Integer points;
    private Business business;
    private User user;
    
    private ArrayList<BillLine> billLines;
    

    public Bill() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public Business getBusiness() {
        return business;
    }

    public void setBusiness(Business business) {
        this.business = business;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ArrayList<BillLine> getBillLines() {
        return billLines;
    }

    public void setBillLines(ArrayList<BillLine> billLines) {
        this.billLines = billLines;
    }
    
    
}
