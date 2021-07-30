package com.example.apipokemon.Webservices.Controllers;

import com.example.apipokemon.Model.User;
import com.example.apipokemon.Webservices.Services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService)
    {
        this.userService = userService;
    }

    @GetMapping("/user")
    @ResponseBody
    public ResponseEntity<User> getUser(@RequestParam String username, @RequestParam String password)
    {
        User user = userService.getUser(username, password);

        if(user != null) {
            user.setPassword("");
            return ResponseEntity.ok(user);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/user")
    public ResponseEntity addUser(@RequestBody User user)
    {
        userService.addUser(user);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
