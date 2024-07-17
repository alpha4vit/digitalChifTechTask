package by.gurinovich.productservice.dto;

public record ProductCategory(

        Long id,

        String title,

        String image,

        Long parentId

) {
}
