package com.project.moneymanager.services;


import com.project.moneymanager.models.User;
import com.project.moneymanager.repositories.UserRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public User findById(Long id) {
        return this.userRepository.findById(id).orElse(null);
    }
    public User registerUser(User user) {
        String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        user.setPassword(hashed);
        return this.userRepository.save(user);
    }
    public User getUserByEmail(String email) {
        return this.userRepository.findByEmail(email);
    }
    public boolean authenticateUser(String email, String password) {
        User user = this.userRepository.findByEmail(email);
        if(user == null)
            return false;

        return BCrypt.checkpw(password, user.getPassword());
    }
}
