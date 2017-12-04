package com.retail.target.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.retail.target.data.ProductFromService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

/**
 * Created by pranith macha on 12/2/17.
 */

@Service
public class ProductNameWebserviceClient {

    private RestTemplate restTemplate;

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private String get(String url) {
        restTemplate = new RestTemplate();
        String result;
        try{
            result = restTemplate.getForObject(url, String.class);
        } catch (RestClientException ex){
            log.error("error while getting name from name ws");
            throw ex;
        }
        return result;
    }

    public ProductFromService getProduct(Long productId) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        ProductFromService productFromService = new ProductFromService();
        String rest = get(Constants.PRODUCT_NAME_WS_URL + productId.toString());
        try {
            productFromService = mapper.readValue(rest, ProductFromService.class);
            log.info("got product name from name ws for id: " + productId.toString());
        } catch (IOException ex) {
            log.error("could not parse JSON response from name ws " + productFromService.toString());
            throw ex;
        }
        return productFromService;
    }
}

