package com.jrueda.store.product;

import com.jrueda.store.product.entity.Category;
import com.jrueda.store.product.entity.Product;
import com.jrueda.store.product.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class ProductRepositoryMockTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void whenFindByCategory_thenReturnListProduct(){
        Product product01 = Product.builder()
                .name("computer")
                .category(Category.builder().id(1L).build())
                .description("")
                .stock(Double.parseDouble("10"))
                .price(Double.parseDouble("1240.99"))
                .status("Created")
                .createdAt(new Date())
                .build();

        productRepository.save(product01);

        List<Product> founds = productRepository.findByCategory(product01.getCategory());
        assertThat(founds.size()).isEqualTo(3);
    }
}
