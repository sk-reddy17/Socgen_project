package com.shashi.CompanyService.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Ipo
{
    @Id
    private String id;
    private String companyName;
    private String stockExchangeName;
    private double price;
    private int shares;
    private String openDateTime;
    private String remarks;
}