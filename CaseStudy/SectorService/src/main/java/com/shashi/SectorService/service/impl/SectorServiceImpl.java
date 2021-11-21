package com.shashi.SectorService.service.impl;

import com.shashi.SectorService.dao.SectorRepository;
import com.shashi.SectorService.dto.CompanyDto;
import com.shashi.SectorService.dto.SectorDto;
import com.shashi.SectorService.mapper.CompanyMapper;
import com.shashi.SectorService.mapper.SectorMapper;
import com.shashi.SectorService.model.Sector;
import com.shashi.SectorService.service.SectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SectorServiceImpl implements SectorService
{
	@Autowired
	private SectorRepository sectorRepository;
	
	@Autowired
	private SectorMapper sectorMapper;
	
	@Autowired
	private CompanyMapper companyMapper;

	@Override
	public SectorDto save(SectorDto sectorDto)
	{
		Sector sector = sectorMapper.toSector(sectorDto);
		sector = sectorRepository.save(sector);
		return sectorMapper.toSectorDto(sector);
	}

	@Override
	public List<SectorDto> findAll() 
	{
		List<Sector> sectors = sectorRepository.findAll();
		return sectorMapper.toSectorDtos(sectors);
	}

	@Override
	public SectorDto findById(String id) 
	{
		Optional<Sector> sector = sectorRepository.findById(id);
		if(!sector.isPresent())
			return null;
		return sectorMapper.toSectorDto(sector.get());
	}
	
	@Override
	public void deleteById(String id) {
		sectorRepository.deleteById(id);
	}

	@Override
	public List<CompanyDto> getCompanies(String id)
	{
		Optional<Sector> sector = sectorRepository.findById(id);
		if(!sector.isPresent())
			return null;
		return companyMapper.toCompanyDtos(sector.get().getCompanies());
	}
	
	/* Feign Client Service */

	@Override
	public SectorDto addCompanyToSector(String sectorName, CompanyDto companyDto) 
	{
		Sector sector = sectorRepository.findByName(sectorName);
		if(sector == null)
			return null;
		sector.getCompanies().add(companyMapper.toCompany(companyDto));
		sector = sectorRepository.save(sector);
		return sectorMapper.toSectorDto(sector);
	}
}
