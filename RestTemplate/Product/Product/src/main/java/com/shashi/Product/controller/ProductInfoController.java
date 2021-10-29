package com.shashi.Product.controller;

import com.shashi.Product.model.ProductInfo;
import com.shashi.Product.model.UserInfo;
import com.shashi.Product.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("product")
public class ProductInfoController {

    @Autowired
    private ProductInfoService service;




    @GetMapping("/home")
    public List<UserInfo> doNothing()
    {
        return service.getdeatilsfromProduct();
    }

    @GetMapping
    public List<ProductInfo> getAll()
    {
        return service.getPlist();
    }

    @PostMapping ("/save")
    public ProductInfo saveProduct(@RequestBody ProductInfo p)
    {
        return  service.addProduct(p);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable int id )
    {
        return service.deleteProduct(id);
    }

    @GetMapping("/{id}")
    public Optional<ProductInfo> getProduct(@PathVariable int id)
    {
        return service.getProduct(id);
    }


}
