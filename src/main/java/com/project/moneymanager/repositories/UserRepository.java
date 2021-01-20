package com.project.moneymanager.repositories;

import com.project.moneymanager.models.User;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
    User findByEmail(String email);
<<<<<<< HEAD
//    List<User> findAll();

=======
    List <User> findAll();
>>>>>>> 80f1d6f64dc5908f5bad97e2f28aee73473b75be

}
