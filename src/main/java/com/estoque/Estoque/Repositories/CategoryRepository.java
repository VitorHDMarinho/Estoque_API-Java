package com.estoque.Estoque.Repositories;

import com.estoque.Estoque.Models.Category;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository  extends JpaRepository<Category, Long>{ 
}
