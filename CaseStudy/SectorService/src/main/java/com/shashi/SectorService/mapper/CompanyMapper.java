package com.shashi.SectorService.mapper;

import java.util.Arrays;
import java.util.List;

import com.shashi.SectorService.dto.CompanyDto;
import com.shashi.SectorService.model.Company;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;


@Component
public class CompanyMapper 
{
	public CompanyDto toCompanyDto(Company company) 
	{
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		CompanyDto companyDto = mapper.map(company, CompanyDto.class);
		return companyDto;
	}
	
	public Company toCompany(CompanyDto companyDto)
	{
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		Company company = mapper.map(companyDto, Company.class);
		return company;
	}
	
	public List<CompanyDto> toCompanyDtos(List<Company> companies)
	{
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		List<CompanyDto> companyDtos = Arrays.asList(mapper.map(companies, CompanyDto[].class));
		return companyDtos;
	}
}