package com.shashi.User.controller;

import com.shashi.User.model.UserInfo;
import com.shashi.User.service.UserInfoService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("user")
public class UserInfoController {
    @Autowired
    private UserInfoService service;
    @GetMapping("/home")
    public String doNothing()
    {
        return "Hey i am working";
    }
    @GetMapping
    public List<UserInfo> getAll()
    {
        return service.getUlist();
    }
    @PostMapping("/save")
    public UserInfo addUser(@RequestBody UserInfo u)
    {
        return service.addUser(u);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable int id)
    {
        return service.deleteUser(id);

    }

    @GetMapping("/{id}")
    public Optional<UserInfo> getUser(@PathVariable int id)
    {
        return service.getUser(id);
    }






}
