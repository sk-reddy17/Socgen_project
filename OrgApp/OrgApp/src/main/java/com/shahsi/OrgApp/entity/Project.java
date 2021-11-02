package com.shahsi.OrgApp.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.*;

@Data
@Entity
public class Project {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private int id;
    private String projectId = UUID.randomUUID().toString();
    private String projectName;
    private int budget;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Employee> employees;
}
