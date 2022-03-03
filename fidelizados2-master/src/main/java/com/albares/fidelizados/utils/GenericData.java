
package com.albares.fidelizados.utils;

import com.albares.fidelizados.db.Business;
import com.albares.fidelizados.db.Login;
import com.albares.fidelizados.db.User;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class GenericData {
    private Login login;
    private User user;
    private Business business;
    private Image image;

    public GenericData() {
    }

    public GenericData(User user) {
        this.user = user;
    }

    public GenericData(Business business) {
        this.business = business;
    }

    public GenericData(Image image) {
        this.image = image;
    }
    
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public Business getBusiness() {
        return business;
    }

    public void setBusiness(Business business) {
        this.business = business;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
    
    
}
