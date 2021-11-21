package com.shashi.CompanyService.dto;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompanyDto
{
    private String id;
    private String name;
    private String code;
    private String turnover;
    private String ceo;
    private String boardOfDirectors;
    private String stockExchangeNames;
    private String sectorName;
    private String description;
}