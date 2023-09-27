package com.school.OnlineSchool.User;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.school.OnlineSchool.Exception.UserAlreadyExistsException;
import com.school.OnlineSchool.Exception.UserNotFoundException;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {
    @Autowired
    private UserRepository userRepository;
    // private final PasswordEncoder passwordEncoder;
  @Autowired
    private PasswordEncoder ePasswordEncoder;
    @Override
    public User add(User user) {
        Optional<User> theUser = userRepository.findByEmail(user.getEmail());
        if (theUser.isPresent()){
            throw new UserAlreadyExistsException("A user with " +user.getEmail() +" already exists");
        }
        // user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setPassword(ePasswordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public String Adduser(User user){

    user.setPassword(ePasswordEncoder.encode(user.getPassword()));
     userRepository.save(user);

     return "user added to the system";
    }
    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    @Transactional
    public void delete(String email) {
        userRepository.deleteByEmail(email);
    }

    @Override
    public User getUser(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("User not found"));
    }

    @Override
    public User update(User user) {
        user.setRole(user.getRole());
        return userRepository.save(user);
    }
}
