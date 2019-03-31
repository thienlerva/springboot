package com.mybatis.controller;

import com.mybatis.model.User;
import com.mybatis.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@RestController
@CrossOrigin("*")
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/sortByName")
    List<User> sortByName() {
        return  userService.sortByLastName();
    }

    @GetMapping("/count")
    Long countUser() {
        return userService.userSize();
    }

    @GetMapping("/all")
    List<User> findAll() {

        return userService.findAll();
    }

    @PostMapping("/create")
    Integer insert(@RequestBody User user) {
        return userService.insert(user);
    }

    @DeleteMapping("/delete/{id}")
    Integer delete(@PathVariable Integer id) {
        return userService.delete(id);
    }

    @PutMapping("/update")
    Integer update(@RequestBody User user) {
        return userService.update(user);
    }

    @PostMapping("/login")
    User verifyLogin(@RequestBody User user) {
        User user1= userService.verifyLogin(user);
        return user1;
    }

    @PostMapping("/validate")
    User validateUsername(@RequestBody User user) {
        User user1 = userService.validateUsername(user);
        if(user1!=null) {
            return user1;
        }
        return null;
    }

}
