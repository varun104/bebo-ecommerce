package com.bebo.app.ecommerce.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Getter@Setter
@Builder @AllArgsConstructor
@NoArgsConstructor
public class Product extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name="native",strategy = "native")
    private Long id;

    private String name;

    private String sku;

    @Column(columnDefinition="TEXT")
    private String description;

    private String category;

    private Long qty;

    private Double price;
}
