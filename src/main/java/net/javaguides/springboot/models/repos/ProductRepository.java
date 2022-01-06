package net.javaguides.springboot.models.repos;

import net.javaguides.springboot.models.entities.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
    List<Product> findByNameContains(String name);
}
