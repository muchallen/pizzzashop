package com.example.demo.models;

import lombok.*;

import javax.persistence.*;
import javax.sound.midi.Sequence;
import java.util.Random;

@Entity
@Getter
@Setter
@ToString
@Table(name = "products")
public class Product {

//    @SequenceGenerator(
//            name = "product_sequence",
//            sequenceName = "product_sequence",
//            allocationSize=1
//    )
//    @GeneratedValue(
//            strategy = GenerationType.SEQUENCE,
//            generator = "product_sequence"
//    )
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    @Column
    private String pName;
    private String pType;
    private Long pQuantity;
    private String pDescription;
    private String pImage;
    private Double pPrice;

    public Product() {
    }
    public Product(String pName, String pType, Long pQuantity, String pDescription, String pImage, Double pPrice) {
        this.pName = pName;
        this.pType = pType;
        this.pQuantity = pQuantity;
        this.pDescription = pDescription;
        this.pImage = pImage;
        this.pPrice = pPrice;
    }

}
