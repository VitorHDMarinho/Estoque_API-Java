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

import com.estoque.Estoque.DTOs.ProductsDTOs.ProductRequestDTO;
import com.estoque.Estoque.DTOs.ProductsDTOs.ProductResponseDTO;
import com.estoque.Estoque.DTOs.ProductsDTOs.ProductUpdateDTO;
import com.estoque.Estoque.Models.Product;
import com.estoque.Estoque.Repositories.ProductRepository;


@RestController
@RequestMapping("Products")
public class ProductController {

    @Autowired
    private ProductRepository repository;
    
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public List<ProductResponseDTO> getAll(){
        List<ProductResponseDTO> productList = repository.findAll().stream()
                                                                   .map(ProductResponseDTO::new)
                                                                   .toList();
        return productList;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> getById(@PathVariable Long id){
        Product product = repository.findById(id).orElseThrow(() -> new RuntimeException("Objeto não encontrado"));
        ProductResponseDTO productDTO = new ProductResponseDTO(product);

        return ResponseEntity.ok(productDTO);
    }



    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public ResponseEntity<Product> saveProduct(@RequestBody ProductRequestDTO productDTO){
        Product product = new Product(productDTO);
        repository.save(product);

        URI location = URI.create("/products/" + product.getId());

        return ResponseEntity.created(location).body(product);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody ProductUpdateDTO productDTO){
        Product product = repository.findById(id).orElseThrow(() -> new RuntimeException("Erro não encontrado"));

        product.setName(productDTO.Name());
        product.setDescription(productDTO.Description());
        product.setUnityPrice(productDTO.UnityPrice());
        product.setStockQuantity(productDTO.StockQuantity());
        product.setRegisterDate(productDTO.RegisterDate());
        product.setCategoryId(productDTO.CategoryId());

        repository.save(product);

        return ResponseEntity.ok(product);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id){
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }


}
