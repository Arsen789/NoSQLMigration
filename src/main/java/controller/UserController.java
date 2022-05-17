package controller;


import exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import repository.UserRepository;
import travel_appModel.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api/user")


public class UserController {
    @Autowired
    UserRepository userRepository;

    
    @GetMapping("/{users}")
    public ResponseEntity<List<User>>getAllUsers(@RequestParam(required = false) String Title) {
        return (ResponseEntity<List<User>>) userRepository.findAll();
    }

    @GetMapping("/users/{user_id}")
    public ResponseEntity<User> getUsersById(@PathVariable("user_id")long user_id){
       // return userRepository.findById(user_id);
        User user = userRepository.findById(user_id)
                .orElseThrow(() -> new ResourceNotFoundException("User not exist with id :" + user_id));
        return ResponseEntity.ok(user);
    }

    @PostMapping(path = "/users")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User user1 = userRepository.save(user);
        return new ResponseEntity<User>(user1,HttpStatus.OK);
        }


    @PutMapping("/users/{user_id}")
    public ResponseEntity<User> updateUser(@PathVariable("user_id") long user_id, @RequestBody User user ) {
       // User u = userRepository.save(user);
       // return new ResponseEntity<User>(u, HttpStatus.OK)
     User user1 = userRepository.findById(user_id)
                .orElseThrow(() -> new ResourceNotFoundException("User not exist with id :" + user_id));
        user.setUsername(user.getUsername());
        user.setEmail(user.getEmail());
        user.setRegistration_code(user.getRegistration_code());
        user.setPassword(user.getPassword());
        user.setBio(user.getBio());

        User updatedUser = userRepository.save(user1);
        return ResponseEntity.ok(updatedUser);
    }
    


    @DeleteMapping("/users/{user_id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable("user_id") long user_id) {
        User user = userRepository.findById(user_id)
                .orElseThrow(() -> new ResourceNotFoundException("User not exist with id :" + user_id));
        userRepository.delete(user);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return new ResponseEntity<HttpStatus>( HttpStatus.OK);
    }

    @DeleteMapping("/users")
    public ResponseEntity<HttpStatus> deleteAllUsers() {
        userRepository.deleteAll();
        return new ResponseEntity<HttpStatus>( HttpStatus.OK);
    }


}
