package sn.isi.l3gl.core.product_core.service;

import org.springframework.stereotype.Service;
import sn.isi.l3gl.core.product_core.entity.Product;
import sn.isi.l3gl.core.product_core.repository.ProductRepository;
import  java.util.List;
/*
    Service metier pour la gestion des produits.
 * Contient toute la logique metier de l'inventaire.
 */
@Service
public class ProductService {

    private ProductRepository productRepository;
    /**
     * Injection du repository via le constructeur.
     * @param productRepository le repository JPA des produits
     */
    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }
    /**
     * Ajoute un nouveau produit dans l'inventaire.
     * @param product le produit à enregistrer
     * @return le produit sauvegardé avec son id généré
     */
    public Product createProduct(Product product){
        return  productRepository.save(product);
    }


    /**
     * Retourne la liste complète de tous les produits en base.
     * @return liste de tous les produits
     */

    public List<Product>ListProducts(){
        return productRepository.findAll();
    }

    /**
     * Met à jour la quantité en stock d'un produit existant.
     * @param id l'identifiant du produit à modifier
     * @param quantity la nouvelle quantité à affecter
     * @return le produit mis à jour
     * @throws RuntimeException si le produit n'est pas trouvé
     */
    public Product updateQuantity(Long id, Integer quantity) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produit non trouvé avec l'id : " + id));
        product.setQuantity(quantity);
        return  productRepository.save(product);
    }

}