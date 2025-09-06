package com.estoque.Estoque.DTOs;

import java.time.LocalDateTime;

import com.estoque.Estoque.Models.Product;

public record ProductResponseDTO(Long Id, String Name, String Description, Long UnityPrice, int StockQuantity, LocalDateTime RegisterDate, Long CategoryId) {
    public ProductResponseDTO(Product product){
        this(product.getId(),product.getName(),product.getDescription(),product.getUnityPrice(),product.getStockQuantity(),product.getRegisterDate(),product.getCategoryId());
    }
}
