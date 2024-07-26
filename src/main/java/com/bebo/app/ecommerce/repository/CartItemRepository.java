package com.bebo.app.ecommerce.repository;

import com.bebo.app.ecommerce.entity.CartItem;
import com.bebo.app.ecommerce.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CartItemRepository extends JpaRepository<CartItem,Long> {

    List<CartItem> findByUser(User user);
}
