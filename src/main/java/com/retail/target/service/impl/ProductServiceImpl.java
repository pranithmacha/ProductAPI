package com.retail.target.service.impl;

import com.retail.target.dto.PriceDTO;
import com.retail.target.dto.ProductDTO;
import com.retail.target.data.ProductDAO;
import com.retail.target.data.ProductFromService;
import com.retail.target.errors.ResourceNotFoundException;
import com.retail.target.repository.ProductRepository;
import com.retail.target.util.ProductNameWebserviceClient;
import com.retail.target.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.repository.MapId;
import org.springframework.stereotype.Service;

import static org.springframework.data.cassandra.repository.support.BasicMapId.id;


/**
 * Created by pranith macha on 12/3/17.
 */

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductNameWebserviceClient productNameWebserviceClient;

    @Autowired
    private ProductRepository myProductRepository;

    private final Logger log = LoggerFactory.getLogger(this.getClass());


    @Override
    public ProductDTO getProduct(long productId) {
        MapId mapid = id("productid", productId);
        ProductDAO productDAO = myProductRepository.findOne(mapid);
        if (productDAO == null) {
            log.error("could not find product with id: " + productId);
            throw new ResourceNotFoundException("product not found");
        }
        PriceDTO price = new PriceDTO();
        price.setCurrencyCode("USD");
        price.setValue(productDAO.getPrice());
        ProductDTO product = new ProductDTO();
        ProductFromService productFromService = productNameWebserviceClient.getProduct(productId);
        product.setCurrent_price(price);
        product.setName(productFromService.getName());
        product.setId(productId);
        return product;
    }

    @Override
    public void updateProduct(ProductDTO product, long productId) {
        MapId mapid = id("productid", productId);
        ProductDAO productDAO = myProductRepository.findOne(mapid);
        if (productDAO == null) {
            log.error("could not find product with id: " + productId);
            throw new ResourceNotFoundException("product not found");
        }
        productDAO.setPrice(product.getCurrent_price().getValue());
        myProductRepository.save(productDAO);
        log.info("successfully update product with id: " + productId);
    }
}
