package com.bebo.app.ecommerce.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;

@Entity
@Getter@Setter
@AllArgsConstructor @NoArgsConstructor
public class CartItem implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name="native",strategy = "native")
    private Long id;

    @OneToOne
    private Product product;

    @OneToOne
    private User user;

    public CartItem(Product product, User user){
        this.product = product;
        this.user = user;
    }

}
