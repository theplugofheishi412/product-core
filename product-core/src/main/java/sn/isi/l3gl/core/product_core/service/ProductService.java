package sn.isi.l3gl.core.product_core.service;

import org.springframework.stereotype.Service;
import sn.isi.l3gl.core.product_core.entity.Product;
import sn.isi.l3gl.core.product_core.repository.ProductRepository;

@Service
public class ProductService {

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public Product createProduct(Product product){
        return  productRepository.save(product);
    }
}
