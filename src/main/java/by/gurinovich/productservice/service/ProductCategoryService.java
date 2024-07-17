package by.gurinovich.productservice.service;


import by.gurinovich.productservice.entity.ProductCategoryEntity;

import java.util.List;

public interface ProductCategoryService {

    ProductCategoryEntity save(ProductCategoryEntity category);

    List<ProductCategoryEntity> getAllByParentId(Long parentCategoryId);

    ProductCategoryEntity getById(Long id);

    void deleteById(Long id);

}
