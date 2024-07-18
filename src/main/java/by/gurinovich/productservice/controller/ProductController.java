package by.gurinovich.productservice.controller;

import by.gurinovich.productservice.dto.Product;
import by.gurinovich.productservice.mapper.ProductMapper;
import by.gurinovich.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;
    private final ProductMapper productMapper;

    @GetMapping("/{id}")
    public ResponseEntity<Product> getById(@PathVariable("id") Long id){
        var product = productService.getById(id);
        return ResponseEntity.ok(productMapper.toDTO(product));
    }

    @PostMapping
    public ResponseEntity<Product> save(@RequestBody Product dto){
        log.info(productMapper.toEntity(dto).toString());
        var saved = productService.save(productMapper.toEntity(dto));
        return ResponseEntity.ok(productMapper.toDTO(saved));
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAll(){
        var products = productService.getAll();
        return ResponseEntity.ok(productMapper.toDTOs(products));
    }

    @GetMapping("/category/{category_id}")
    public ResponseEntity<List<Product>> getAllByCategoryId(@PathVariable("category_id") Long categoryId){
        var products = productService.getAllByCategoryId(categoryId);
        return ResponseEntity.ok(productMapper.toDTOs(products));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> save(@PathVariable("id") Long id, @RequestBody Product dto){
        var updated = productService.update(id, productMapper.toEntity(dto));
        return ResponseEntity.ok(productMapper.toDTO(updated));
    }

}
