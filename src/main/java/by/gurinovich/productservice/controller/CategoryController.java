package by.gurinovich.productservice.controller;

import by.gurinovich.productservice.dto.ProductCategory;
import by.gurinovich.productservice.mapper.ProductCategoryMapper;
import by.gurinovich.productservice.service.ProductCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/category")
public class CategoryController {

    private final ProductCategoryService productCategoryService;
    private final ProductCategoryMapper productCategoryMapper;

    @GetMapping("/{id}")
    public ResponseEntity<ProductCategory> getById(@PathVariable("id") Long id){
        var category = productCategoryService.getById(id);
        return ResponseEntity.ok(productCategoryMapper.toDTO(category));
    }

    @GetMapping("/parent/{parent_id}")
    public ResponseEntity<List<ProductCategory>> getAllByParentId(@PathVariable("parent_id") Long parentId){
        var categories = productCategoryService.getAllByParentId(parentId);
        return ResponseEntity.ok(productCategoryMapper.toDTOs(categories));
    }

    @PostMapping
    public ResponseEntity<ProductCategory> save(@RequestBody ProductCategory category){
        var saved = productCategoryService.save(productCategoryMapper.toEntity(category));
        return ResponseEntity.ok(productCategoryMapper.toDTO(saved));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteById(@PathVariable("id") Long id){
        productCategoryService.deleteById(id);
    }

}
