package com.jrueda.store.product.repository;

import com.jrueda.store.product.entity.Category;
import com.jrueda.store.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    public List<Product> findByCategory(Category category);
    public Product findByName(String name);
}
