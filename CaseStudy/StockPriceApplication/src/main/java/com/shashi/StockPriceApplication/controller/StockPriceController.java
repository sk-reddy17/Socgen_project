package com.shashi.StockPriceApplication.controller;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.shashi.StockPriceApplication.dto.CompanyCompareRequest;
import com.shashi.StockPriceApplication.dto.SectorCompareRequest;
import com.shashi.StockPriceApplication.dto.StockPriceDto;
import com.shashi.StockPriceApplication.exception.StockPriceNotFoundException;
import com.shashi.StockPriceApplication.service.StockPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/stock-price-service/stockPrices")
public class StockPriceController 
{
	@Autowired
	private StockPriceService stockPriceService;
	
	@GetMapping(path = "")
	public ResponseEntity<List<StockPriceDto>> findAll() {
		return ResponseEntity.ok(stockPriceService.findAll());
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<StockPriceDto> findById(@PathVariable String id)
			throws StockPriceNotFoundException
	{
		StockPriceDto stockPriceDto = stockPriceService.findById(id);
		if(stockPriceDto == null) {
			throw new StockPriceNotFoundException("Stock Price Not Found with id : " + id);
		}
		return ResponseEntity.ok(stockPriceDto);
	}
	
	@GetMapping(path = "/compareCompany")
	public ResponseEntity<?> companyComparison(@RequestBody CompanyCompareRequest compareRequest)
	{
		List<StockPriceDto> stockPriceDtos = null;
		try {
			stockPriceDtos = stockPriceService.getStockPricesForCompanyComparison(compareRequest);
		} catch (ParseException e) {
			return ResponseEntity
					.status(HttpStatus.BAD_REQUEST)
					.body("Invalid Date Format");
		}
		return ResponseEntity.ok(stockPriceDtos);
	}
	
	@GetMapping(path = "/compareSector")
	@HystrixCommand(fallbackMethod = "defaultResponse")
	public ResponseEntity<?> sectorComparison(@RequestBody SectorCompareRequest compareRequest)
	{
		List<StockPriceDto> stockPriceDtos = null;
		try {
			stockPriceDtos = stockPriceService.getStockPricesForSectorComparison(compareRequest);
		} catch (ParseException e) {
			return ResponseEntity
					.status(HttpStatus.BAD_REQUEST)
					.body("Invalid Date Format");
		}
		return ResponseEntity.ok(stockPriceDtos);
	}
	
	@PostMapping(path = "")
	public ResponseEntity<?> save(@RequestBody List<StockPriceDto> stockPriceDtos) {
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(stockPriceService.save(stockPriceDtos));
	}
	
	@PutMapping(path = "")
	public ResponseEntity<StockPriceDto> update(@RequestBody StockPriceDto stockPriceDto)
			throws StockPriceNotFoundException
	{
		StockPriceDto updatedStockPriceDto = stockPriceService.update(stockPriceDto);
		if(updatedStockPriceDto == null) {
			throw new StockPriceNotFoundException("Stock Price not found with id : " + stockPriceDto.getId());
		}
		return ResponseEntity.ok(updatedStockPriceDto);
	}
	
	@DeleteMapping(path = "/{id}")
	public void deleteById(@PathVariable String id) {
		stockPriceService.deleteById(id);
	}
	
	/* Feign Client Default Response */
	
	public ResponseEntity<?> defaultResponse(@RequestBody SectorCompareRequest compareRequest) {
		String err = "Fallback error as the microservice is down.";
		return ResponseEntity
				.status(HttpStatus.SERVICE_UNAVAILABLE)
				.body(err);
	}
}
