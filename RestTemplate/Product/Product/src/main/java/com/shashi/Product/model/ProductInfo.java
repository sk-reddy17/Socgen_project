package com.shashi.Product.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;


public class ProductInfo {

    private int id;
    private String companyname;
    private List<Integer> users;

    @Override
    public String toString() {
        return "ProductInfo{" +
                "id=" + id +
                ", companyname='" + companyname + '\'' +
                ", users=" + users +
                '}';
    }

    public ProductInfo(int id, String companyname, List<Integer> users) {
        this.id = id;
        this.companyname = companyname;
        this.users = users;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public List<Integer> getUsers() {
        return users;
    }

    public void setUsers(List<Integer> users) {
        this.users = users;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
