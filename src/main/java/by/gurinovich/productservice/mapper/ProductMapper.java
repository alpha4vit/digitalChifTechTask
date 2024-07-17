package by.gurinovich.productservice.mapper;

import by.gurinovich.productservice.dto.Product;
import by.gurinovich.productservice.entity.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        uses = {
                ProductCategoryMapper.class
        }
)
public interface ProductMapper {

    @Mapping(target = "measurementTypeId", source = "measurementType.id")
    Product toDTO(ProductEntity entity);

    @Mapping(target = "measurementType.id", source = "measurementTypeId")
    ProductEntity toEntity(Product dto);
    List<Product> toDTOs(List<ProductEntity> products);
    List<ProductEntity> toEntities(List<Product> dtos);
}
