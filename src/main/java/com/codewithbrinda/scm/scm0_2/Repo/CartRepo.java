package com.codewithbrinda.scm.scm0_2.Repo;

import com.codewithbrinda.scm.scm0_2.entities.Cart;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepo extends CrudRepository<Cart, Integer> {

}
