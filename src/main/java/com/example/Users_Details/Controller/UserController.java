package com.example.Users_Details.Controller;


import com.example.Users_Details.Entities.User_Entity;
import com.example.Users_Details.Services.User_Service;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private User_Service userService;

    @PostMapping("/createUser")
    public ResponseEntity<User_Entity> createUser(@RequestBody User_Entity userEntity)
    {
        User_Entity savedUser = userService.newUser(userEntity);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @GetMapping("/getAllUsers")
    public ResponseEntity<List<User_Entity>> getAllUsers()
    {
        List<User_Entity> users = userService.getAllUsers();
        if(users == null)
        {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User_Entity> getById(@PathVariable Long id)
    {
        return  new ResponseEntity<>(userService.findingById(id), HttpStatus.FOUND);
    }

    @PatchMapping("/updateUsers")
    public ResponseEntity<User_Entity> updateUser(@RequestBody User_Entity user)
    {
        return new ResponseEntity<User_Entity>(userService.updateUser(user), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<String> deletingUser(@PathVariable Long id)
    {
        boolean isDeleted = userService.deleteUser(id);
        if(isDeleted)
        {
            return ResponseEntity.ok("User with ID " + id + " deleted successfully.");
//            return ResponseEntity.ok(Collections.singleton().Map("status", "true")); ResponseEntity<Map<String, String>> deletingUser
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User with ID " + id + " not found.");
        }
    }
}
