package com.example.demo.controllers;

import com.example.demo.models.Product;
import com.example.demo.services.ProductNotFoundException;
import com.example.demo.services.ProductsService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/products")
public class ProductsController{
    static List<Product> myProducts = List.of(
            new Product("IPHONE SE 64 GB","mobile",
                    300L,"iPhone SE packs a ",
                    "iphonese64gb.jpg",9_499.00 ),
            new Product("SAMSUNG GALAXY A22","mobile",
                                300L,"iPhone SE packs a remarkably powerful ",
                                "samsunggalaxyA2.jpg",3_999.00  ),
             new Product("Huawei Nova 81","mobile",
                                 300L,"iPhone SE packs a remarkably powerful",
                                 "huaweinova81.jpg",4_999.00  ),
            new Product("Hisense Infinity","mobile",
                    300L,"iPhone SE packs a remarkably powerful chip into our most popular size at our most affordable price. It’s just what you’ve been waiting for." +
                    " Durable glass and aluminum design. Brilliant 4.7” Retina HD",
                    "hisenseinfinity.jpg",2_999.00  ),
             new Product("Nokia 3.4 Dual Sim","mobile",
                                 300L,"iPhone SE packs a remarkably " +
                     "powerful chip into our most popular size at our most affordable price. ",
                                 "Nokia34dualsim.jpg",999.00  )

    );

    private final ProductsService productsService;

    @Autowired
    public ProductsController(ProductsService productsService) {
        this.productsService = productsService;

    }

    @GetMapping("/all")
    public ResponseEntity<List<Product>> getAllProducts(){
        return  new ResponseEntity<>(productsService.getProducts(), HttpStatus.OK);
    }

    @GetMapping("/single/{id}")
    public Product getProduct(@PathVariable("id") Long id){
        return  productsService.getProduct(id);
    }

    @GetMapping("/add-dummy")
    public ResponseEntity<Integer> addManyProducts(Product product){
        myProducts.forEach(prod -> productsService.addProduct(prod));
        return  new ResponseEntity<>(0, HttpStatus.OK);
    }

    @PostMapping("/new-product")
    public ResponseEntity<Product> addProduct(@RequestBody  Product product){
        return new ResponseEntity<>(productsService.addProduct(product),HttpStatus.ACCEPTED);
    }

    @PutMapping("/update-product")
    public ResponseEntity<Product> updateProduct(Product product){
        return new ResponseEntity<>(productsService.addProduct(product),HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Integer> removeProduct(@PathVariable("id") Long id) throws ProductNotFoundException {
        return new ResponseEntity<>(productsService.deleteProduct(id),HttpStatus.ACCEPTED);
    }





}
