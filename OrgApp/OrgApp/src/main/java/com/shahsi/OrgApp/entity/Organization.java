package com.shahsi.OrgApp.entity;


import lombok.Data;

import javax.persistence.*;
import java.util.*;
import java.util.UUID;

@Data
@Entity
public class Organization {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private int id;
    private String orgId = UUID.randomUUID().toString();
    private  String orgName;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Project> projects;

}
