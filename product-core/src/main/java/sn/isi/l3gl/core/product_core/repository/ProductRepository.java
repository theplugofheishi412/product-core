package sn.isi.l3gl.core.product_core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.isi.l3gl.core.product_core.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    Long countByQuantityIsLessThanEqual(Integer quantity);
}
