package com.codewithbrinda.scm.scm0_2.Service;


import com.codewithbrinda.scm.scm0_2.entities.Cart;
import com.codewithbrinda.scm.scm0_2.entities.Product;

public interface CartService {

    Cart addItemToCart(Product product, int quantity, String email);

    Cart updateCart(Product product, int quantity, String username);

    Cart removeItemFromCart(Product product, String username);

    void deleteCartById(Long id);

    Cart getCart(String username);

}
