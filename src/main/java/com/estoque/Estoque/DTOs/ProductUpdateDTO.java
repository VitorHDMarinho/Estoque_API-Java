package com.estoque.Estoque.DTOs;

import java.time.LocalDateTime;

public record ProductUpdateDTO(Long Id, String Name, String Description, Long UnityPrice, int StockQuantity, LocalDateTime RegisterDate, Long CategoryId) {    
}
