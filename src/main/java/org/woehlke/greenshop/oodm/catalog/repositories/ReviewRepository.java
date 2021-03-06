package org.woehlke.greenshop.oodm.catalog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.woehlke.greenshop.oodm.catalog.entities.Product;
import org.woehlke.greenshop.oodm.catalog.entities.Review;

import java.util.List;

/**
 * Created by tw on 25.12.14.
 */
public interface ReviewRepository extends JpaRepository<Review,Long> {

        List<Review> findByProduct(Product product);

        List<Review> findByCustomersId(Long id);
}
