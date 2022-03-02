
package com.albares.clothes.db;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Brand {
    private Integer brand_id;
    private String name;
    private String origin;

    public Brand(){}

    public Integer getBrand_id() {
        return brand_id;
    }

    public void setBrand_id(Integer brand_id) {
        this.brand_id = brand_id;
    }
    
    public Brand(Integer brand_id, String name, String origin) {
        this.brand_id = brand_id;
        this.name = name;
        this.origin = origin;
    }
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }
    
    
}
