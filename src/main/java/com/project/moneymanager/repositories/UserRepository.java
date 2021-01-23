package com.project.moneymanager.repositories;

import com.project.moneymanager.models.User;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
    User findByEmail(String email);
<<<<<<< HEAD
    List<User> findAll();
=======
//    List<User> findAll();
    List <User> findAll();
>>>>>>> b59787f4103aa518a01d69b83b5af0496316177d
}
