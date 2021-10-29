package com.shashi.User.service;

import com.shashi.User.model.ProductInfo;
import com.shashi.User.model.UserInfo;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserInfoService {
    @Autowired
    private RestTemplate restTemplate;

    List<UserInfo> Ulist = new ArrayList<>();

    public List<UserInfo> getUlist() {
        return Ulist;
    }

    public UserInfo addUser(UserInfo u)
    {
        Ulist.add(u);
        return u;
    }

    public ResponseEntity<String> deleteUser(int id)
    {
        Ulist = Ulist.stream().filter(s -> !(s.getId()==id)).collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.NON_AUTHORITATIVE_INFORMATION)
                .body("***********Deleted Sucessfully************");

    }
    public Optional<UserInfo> getUser(int id)
    {
        Optional<UserInfo> user = Ulist.stream().filter(s -> s.getId() == id).findAny();
        return user;
    }

    public List<String> getUserComanyName(int id)
    {
//       ProductInfo cname = restTemplate.getForObject("https://localhost:8082/product", ProductInfo.class);
//       return


    }
}
