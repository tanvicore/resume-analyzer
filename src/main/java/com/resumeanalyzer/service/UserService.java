package com.resumeanalyzer.service;

import com.resumeanalyzer.model.User;
import com.resumeanalyzer.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User registerUser(User user) {

        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new RuntimeException("Email already registered");
        }

        // Save password as plain text (for now)
        return userRepository.save(user);
    }
}

