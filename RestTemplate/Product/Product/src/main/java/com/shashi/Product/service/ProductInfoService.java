package com.shashi.Product.service;

import com.shashi.Product.model.ProductInfo;
import com.shashi.Product.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.*;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

@Service
public class ProductInfoService {

    @Autowired
    private RestTemplate restTemplate;

    List<ProductInfo> Plist = new ArrayList<>();


    public List<ProductInfo> getPlist() {
        return Plist;
    }

    public ProductInfo addProduct(ProductInfo u)
    {
        Plist.add(u);
        return u;
    }

    public ResponseEntity<String> deleteProduct(int id)
    {
        Plist = Plist.stream().filter(s -> !(s.getId()==id)).collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.NON_AUTHORITATIVE_INFORMATION)
                .body("***********Deleted Sucessfully************");

    }
    public Optional<ProductInfo> getProduct(int id)
    {
        Optional<ProductInfo> product = Plist.stream().filter(s -> s.getId() == id).findAny();
        return product;
    }
    public List<UserInfo> getdeatilsfromProduct()
    {

        List<List<Integer>> l = Plist.stream().map(ProductInfo::getUsers).collect(Collectors.toList());
        List<Integer> list = l.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());
    //to get users list by their ids

        return list.stream().map( i ->
                {
                        UserInfo user = restTemplate.getForObject("http://localhost:8081/user/" + i, UserInfo.class);
            return user;
                        //return new UserInfo(user.getId(),user.getUsername(), user.getSalary());
        })
                .collect(Collectors.toList());


    }
}


