package com.estoque.Estoque.Models;

import java.time.LocalDateTime;

import com.estoque.Estoque.DTOs.ProductRequestDTO;
import com.estoque.Estoque.DTOs.ProductUpdateDTO;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "products")
@Entity(name = "product")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "Id")
public class Product {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long Id;

    @Column(name = "name")
    private String Name;

    @Column(name = "description")
    private String Description;

    @Column(name = "unityprice")
    private Long UnityPrice;

    @Column(name = "stockquantity")
    private int StockQuantity;

    @Column(name = "registerdate")
    private LocalDateTime RegisterDate;

    @Column(name = "categoryid")
    private Long CategoryId;


    public Product(ProductRequestDTO productDTO){
        this.Name = productDTO.Name();
        this.Description = productDTO.Description();
        this.UnityPrice = productDTO.UnityPrice();
        this.StockQuantity = productDTO.StockQuantity();
        this.RegisterDate = productDTO.RegisterDate();
        this.CategoryId = productDTO.CategoryId();
    }




    
}
