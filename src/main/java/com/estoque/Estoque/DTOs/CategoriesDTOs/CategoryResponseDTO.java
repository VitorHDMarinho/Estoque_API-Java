package com.estoque.Estoque.DTOs.CategoriesDTOs;

import com.estoque.Estoque.Models.Category;

public record CategoryResponseDTO(long Id, String Nome, String Description){
    public CategoryResponseDTO(Category category){
        this(category.getId(),category.getName(),category.getDescription());
    }
}
