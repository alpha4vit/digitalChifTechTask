package by.gurinovich.productservice.service.impl;

import by.gurinovich.productservice.entity.ProductCategoryEntity;
import by.gurinovich.productservice.repository.ProductCategoryRepository;
import by.gurinovich.productservice.service.ProductCategoryService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductCategoryServiceImpl implements ProductCategoryService {

    private final ProductCategoryRepository categoryRepository;

    @Override
    public ProductCategoryEntity save(ProductCategoryEntity category) {
        if (category.getParent() == null)
            category.setParent(categoryRepository.getRootCategory());
        category.setTitle(StringUtils.normalizeSpace(category.getTitle()));
        return categoryRepository.save(category);
    }

    @Override
    public List<ProductCategoryEntity> getAllByParentId(Long parentCategoryId) {
        var category = getById(parentCategoryId);
        return categoryRepository.findAllByParent(category);
    }

    @Override
    public ProductCategoryEntity getById(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Category with this id not found!"));
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        getById(id);
        categoryRepository.deleteById(id);
    }

}
