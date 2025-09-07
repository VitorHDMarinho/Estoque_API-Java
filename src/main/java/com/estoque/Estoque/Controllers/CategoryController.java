package com.estoque.Estoque.Controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estoque.Estoque.DTOs.CategoriesDTOs.CategoryRequestDTO;
import com.estoque.Estoque.DTOs.CategoriesDTOs.CategoryResponseDTO;
import com.estoque.Estoque.DTOs.CategoriesDTOs.CategoryUpdateDTO;
import com.estoque.Estoque.Models.Category;
import com.estoque.Estoque.Repositories.CategoryRepository;

@RestController
@RequestMapping("Categories")
public class CategoryController {
    
    @Autowired
    private CategoryRepository repository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public ResponseEntity<List<CategoryResponseDTO>> getAll(){
        List<CategoryResponseDTO> categoryDTO = repository.findAll().stream().map(CategoryResponseDTO::new).toList();
        if(categoryDTO.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(categoryDTO);
    }


    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponseDTO> getById(@PathVariable long id){
        return repository.findById(id).map(category -> {
            return ResponseEntity.ok(new CategoryResponseDTO(category));
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }


    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public ResponseEntity<CategoryResponseDTO> saveCategory(@RequestBody CategoryRequestDTO categoryDTO){
        Category category = new Category(categoryDTO);
        repository.save(category);
        CategoryResponseDTO categoryResponse = new CategoryResponseDTO(category);

        URI location = URI.create("/Categories/" + category.getId());

        return ResponseEntity.created(location).body(categoryResponse);
    }



    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PutMapping("/{id}")
    public ResponseEntity<CategoryResponseDTO> updateCategory(@PathVariable long id, @RequestBody CategoryUpdateDTO categoryDTO){
        return repository.findById(id).map(category -> {
            category.setName(categoryDTO.Name());
            category.setDescription(categoryDTO.Description());
            Category updated = repository.save(category);
            return ResponseEntity.ok(new CategoryResponseDTO(updated));
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable long id){
        if(!repository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }







}
