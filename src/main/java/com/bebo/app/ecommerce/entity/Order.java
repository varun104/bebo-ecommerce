package com.bebo.app.ecommerce.entity;

import com.bebo.app.ecommerce.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="orders")
@AllArgsConstructor@NoArgsConstructor
@Getter@Setter
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name="native",strategy = "native")
    private Long id;

    private String description;

    private String address;

    private String paymentType;

    private OrderStatus orderStatus;

    private LocalDateTime orderDateTime;

    private Double price;

    @ManyToOne(cascade= CascadeType.MERGE)
    @JoinColumn(name="user_id", referencedColumnName = "user_id")
    private User user;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, targetEntity = CartItem.class)
    private List<CartItem> carts;


}
