package by.gurinovich.productservice.mapper;

import by.gurinovich.productservice.dto.ProductCategory;
import by.gurinovich.productservice.entity.ProductCategoryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProductCategoryMapper {

    @Mapping(source = "parentId", target = "parent", qualifiedByName = "mapParentIdToParent")
    ProductCategoryEntity toEntity(ProductCategory dto);

    @Mapping(source = "parent.id", target = "parentId")
    ProductCategory toDTO(ProductCategoryEntity entity);

    List<ProductCategoryEntity> toEntities(List<ProductCategory> dtos);

    List<ProductCategory> toDTOs(List<ProductCategoryEntity> entities);

    @Named("mapParentIdToParent")
    default ProductCategoryEntity mapParentIdToParent(Long parentId) {
        if (parentId == null) {
            return null;
        }
        ProductCategoryEntity parent = new ProductCategoryEntity();
        parent.setId(parentId);
        return parent;
    }

}
