package com.codewithbrinda.scm.scm0_2.Repo;

import com.codewithbrinda.scm.scm0_2.entities.Product;
import com.codewithbrinda.scm.scm0_2.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {

    List<Product> findByUser(User user);

    @Query("SELECT c FROM Product c WHERE c.user.userid = :UserId")
    List<Product> findByUserId(@Param("UserId") int userId);
}
