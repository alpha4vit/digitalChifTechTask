package by.gurinovich.productservice.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "product_category")
public class ProductCategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String image;

    @ManyToOne
    @JoinColumn(name = "parent_id", referencedColumnName = "id")
    private ProductCategoryEntity parent;

}