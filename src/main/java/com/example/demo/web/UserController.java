package com.example.demo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.AppUser;
import com.example.demo.repositories.UserRepository;

@RestController
@RequestMapping("/uri/v1/user")
public class UserController {
	@Autowired  
	private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/register")
    public AppUser registerUser(@RequestBody AppUser user) {
        return userRepository.save(user);
    }
    @GetMapping("/all")
    public List<AppUser> getAllUser() {
        return userRepository.findAll();
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody AppUser user) { 
        AppUser exist = userRepository.findByUsername(user.getUsername());
        if (exist != null && exist.getPassword().equals(user.getPassword())) {
        	return new ResponseEntity<> (exist, HttpStatus.OK);
        }
        else {
        	return new ResponseEntity<> (HttpStatus.UNAUTHORIZED);
        }
    }
}
