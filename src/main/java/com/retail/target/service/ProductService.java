package com.retail.target.service;

import com.retail.target.dto.ProductDTO;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * Created by pranith macha on 11/30/17.
 */

@Service
public interface ProductService {

    /**
     * service method to get a product by its id. gets name from product name ws and price from database
     * @param id
     * @return
     * @throws IOException
     */
    ProductDTO getProduct(long id);

    /**
     * service method to update a product
     * @param product
     * @param id
     */
    void updateProduct(ProductDTO product, long id);
}
