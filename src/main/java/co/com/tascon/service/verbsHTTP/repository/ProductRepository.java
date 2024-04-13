package co.com.tascon.service.verbsHTTP.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import co.com.tascon.service.verbsHTTP.model.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, String>{

}
