package com.shashi.StockPriceApplication.feignclient;

import com.shashi.StockPriceApplication.dto.CompanyDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("sector-service")
public interface SectorClient 
{
	@GetMapping("/sectors/{sectorName}/companies")
	public List<CompanyDto> getSectorCompanies(@PathVariable String sectorName);
}
