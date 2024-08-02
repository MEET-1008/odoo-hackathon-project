package com.codewithbrinda.scm.scm0_2.Service.impl;

import com.codewithbrinda.scm.scm0_2.Repo.CartRepo;
import com.codewithbrinda.scm.scm0_2.Repo.ProductRepo;
import com.codewithbrinda.scm.scm0_2.Repo.UserRepo;
import com.codewithbrinda.scm.scm0_2.Service.CartService;
import com.codewithbrinda.scm.scm0_2.entities.Cart;
import com.codewithbrinda.scm.scm0_2.entities.Product;
import com.codewithbrinda.scm.scm0_2.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartServiceIMPL implements CartService {

    @Autowired
    CartRepo cartRepo;

    @Autowired
    UserRepo userRepo;

    @Autowired
    ProductRepo productRepo;

    @Override
    public Cart addItemToCart(Product product, int quantity, String email) {

        Optional<User> user = userRepo.findByEmail(email);
            
        return null;
    }

    @Override
    public Cart updateCart(Product product, int quantity, String username) {
        return null;
    }

    @Override
    public Cart removeItemFromCart(Product product, String username) {
        return null;
    }

    @Override
    public void deleteCartById(Long id) {

    }

    @Override
    public Cart getCart(String username) {
        return null;
    }
}
