package com.estoque.Estoque.Models;

import com.estoque.Estoque.DTOs.CategoriesDTOs.CategoryRequestDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "Categories")
@Entity(name = "Category")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "Id")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long Id;

    @Column(name = "name")
    private String Name;

    @Column(name = "description")
    private String Description;

    public Category(CategoryRequestDTO categoryDTO){
        this.Name = categoryDTO.Name();
        this.Description = categoryDTO.Description();
    }

}
