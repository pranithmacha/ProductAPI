package com.retail.target.dto;

/**
 * Created by pranith macha on 12/3/17.
 */
public class ProductDTO {

    private Long id;
    private String name;
    private PriceDTO current_price;

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

    public PriceDTO getCurrent_price() {
        return current_price;
    }

    public void setCurrent_price(PriceDTO current_price) {
        this.current_price = current_price;
    }


}
