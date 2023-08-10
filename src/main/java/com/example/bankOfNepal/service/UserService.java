package com.example.bankOfNepal.service;

import com.example.bankOfNepal.entities.User;
import com.example.bankOfNepal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public long getUserCount(){
        System.out.println(userRepository.count());
        return userRepository.count();
    }
    public Iterable<User> getAllUsers() {
        return  userRepository.findAll();
    }

    public Optional<User> getUserById(Integer id) {
        return userRepository.findById(id);
    }

    public User addUser(User user){
        return userRepository.save(user);
    }

    public String removeUser(Integer id) {
        Optional<User> userOptional = userRepository.findById(id);

        if (userOptional.isPresent()) {
            userRepository.deleteById(id);
            return "User has been deleted successfully.";
        } else {
            return "User with ID " + id + " does not exist.";
        }
    }


    public User updateUser(User user, Integer id) {
        Optional<User> existingUserOptional = userRepository.findById(id);
        User updatedUser = null;
        if (existingUserOptional.isPresent()) {
            User existingUser = existingUserOptional.get();

            existingUser.setUsername(user.getUsername());
            existingUser.setEmail(user.getEmail());
            existingUser.setPassword(user.getPassword());

            updatedUser = userRepository.save(existingUser);
        }
        return updatedUser;
    }

}
