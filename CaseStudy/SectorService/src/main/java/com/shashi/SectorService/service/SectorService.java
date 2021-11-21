package com.shashi.SectorService.service;

import com.shashi.SectorService.dto.CompanyDto;
import com.shashi.SectorService.dto.SectorDto;

import java.util.List;

public interface SectorService 
{
	public SectorDto save(SectorDto sectorDto);
	public List<SectorDto> findAll() ;
	public SectorDto findById(String id);
	public void deleteById(String id);
	public List<CompanyDto> getCompanies(String id);
	public SectorDto addCompanyToSector(String sectorName, CompanyDto companyDto);
}
