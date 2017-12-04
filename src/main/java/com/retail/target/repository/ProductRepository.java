package com.retail.target.repository;

import com.retail.target.data.ProductDAO;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by pranith macha on 12/3/17.
 */

@Repository
public interface ProductRepository extends CassandraRepository<ProductDAO> {
}