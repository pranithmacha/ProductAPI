package com.retail.target.data;

/**
 * Created by pranith macha on 12/3/17.
 */
public class ProductFromService {

    private Long id;
    private String name;

    public String toString() {
        return "product with id: " + this.id + " name: " + this.name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
