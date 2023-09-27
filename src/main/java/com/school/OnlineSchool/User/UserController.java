package com.school.OnlineSchool.User;


import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    @Autowired
    private  UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder ePasswordEncoder;


    @PostMapping("/new")
    public String Adduser(@RequestBody User user){
    return userService.Adduser(user);
    }
  
    @GetMapping("/welcome")
    public String  welcome(){
        return "welcome this endpoint is not secure" ;
    }

    // @GetMapping("/all")
    // @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    // public ResponseEntity<List<User>> getAllUser(){
    //     return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.FOUND);
    // }

    @GetMapping("/all")
    // @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<User> getAllUser(){
        return userRepository.findAll();
    }



    //   @PostMapping("/new")
    // public ResponseEntity<User> adduser(@RequestBody User user){
    //     return ResponseEntity.ok(userService.add(user));
    // }

    // @PreAuthorize("hasAnyAuthority('ROLE_ADMIN','ROLE_USER')")
    @PostMapping("/add")
    public ResponseEntity<User> add(@RequestBody User user){
        return ResponseEntity.ok(userService.add(user));
    }


    //  @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/{email}")
    public User getByEmail(@PathVariable("email") String email){
        return  userService.getUser(email);
    }

    //  @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @DeleteMapping("/{email}")
    public void delete(@PathVariable("email") String email){
        userService.delete(email);
    }

    @PutMapping("/update")
    public ResponseEntity<User> update(@RequestBody User user){
        return ResponseEntity.ok(userService.update(user));
    }

}

