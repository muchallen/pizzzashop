package com.example.demo.services;

import com.example.demo.interfaces.ProductsInterface;
import com.example.demo.models.Product;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ProductsService {
    private final ProductsInterface productsInterface;

    public List<Product> getProducts (){
        return productsInterface.findAll();
    }

    public Product getProduct (Long id){
        return productsInterface.findById(id).get();
    }

    public int deleteProduct(Long id) throws ProductNotFoundException {
        productsInterface.delete(productsInterface.findById(id).orElseThrow( ()->new ProductNotFoundException("Cannot find Product with pid "+id)));
        return 1;
    }

    public  Product addProduct(Product product){
          productsInterface.save(product);
          return product;
    }

    public void UpdateProduct(Product product){
        productsInterface.save(product);
    }


}
