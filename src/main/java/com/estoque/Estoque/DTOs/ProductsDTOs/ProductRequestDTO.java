package com.estoque.Estoque.DTOs.ProductsDTOs;

import java.time.LocalDateTime;

public record ProductRequestDTO(String Name, String Description, Long UnityPrice, int StockQuantity, LocalDateTime RegisterDate, Long CategoryId) {
}
