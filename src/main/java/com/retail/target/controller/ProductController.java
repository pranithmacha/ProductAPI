package com.retail.target.controller;


import com.retail.target.dto.ProductDTO;
import com.retail.target.errors.ResourceNotFoundException;
import com.retail.target.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.IOException;


/**
 * Created by pranith macha on 12/2/17.
 */

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    /**
     * api method to get a product by its id
     *
     * @param id
     * @return com.retail.target.dto.ProductDTO
     */
    @GetMapping(path = "/{id}")
    public ProductDTO getProduct(@PathVariable("id") long id) {
        ProductDTO product;
        try {
            product = productService.getProduct(id);
        } catch (IOException ex) {
            throw new ResourceNotFoundException("could not fetch name");
        }
        return product;
    }

    /**
     * api method to update a product
     *
     * @param product
     * @param id
     */
    @PutMapping(path = "/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void updateProduct(@RequestBody ProductDTO product, @PathVariable("id") long id) {
        productService.updateProduct(product, id);
    }
}
