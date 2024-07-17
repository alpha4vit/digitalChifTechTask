package by.gurinovich.productservice.repository;

import by.gurinovich.productservice.entity.ProductCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductCategoryRepository extends JpaRepository<ProductCategoryEntity, Long> {

    List<ProductCategoryEntity> findAllByParent(ProductCategoryEntity parent);

    @Query(nativeQuery = true, value = "SELECT * from product_category where id=1")
    ProductCategoryEntity getRootCategory();

}
