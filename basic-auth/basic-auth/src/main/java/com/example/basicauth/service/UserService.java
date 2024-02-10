package com.example.basicauth.service;

import com.example.basicauth.dto.CreateUserRequest;
import com.example.basicauth.model.User;
import com.example.basicauth.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    private final BCryptPasswordEncoder passwordEncoder;


    public UserService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Optional<User> getByUserName(String userName){
        return userRepository.findByUserName(userName);
    }

    public User createUser(CreateUserRequest request){
        User newUser = User.builder()
                .name(request.name())
                .username(request.userName())
                .password(passwordEncoder.encode(request.password()))
                .authorities(request.authorities())
                .accountNonExpired(true)
                .accountNonLocked(true)
                .isEnabled(true)
                .isCredentialsNonExpired(true)

            .build();

        return userRepository.save(newUser);
    }
}
