package com.retail.target.data;

import org.springframework.cassandra.core.Ordering;
import org.springframework.cassandra.core.PrimaryKeyType;
import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.mapping.Table;

/**
 * Created by pranith macha on 11/30/17.
 */

@Table(value = "product")
public class ProductDAO {


    @PrimaryKeyColumn(name = "productid", type = PrimaryKeyType.PARTITIONED, ordering = Ordering.DESCENDING)
    private long productid;

    @Column(value = "price")
    private double price;

    public long getProductid() {
        return productid;
    }

    public void setProductid(long productid) {
        this.productid = productid;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
