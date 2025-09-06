package com.estoque.Estoque.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estoque.Estoque.Models.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
}
