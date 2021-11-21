package com.shashi.StockPriceApplication.service;
import com.shashi.StockPriceApplication.dto.CompanyCompareRequest;
import com.shashi.StockPriceApplication.dto.SectorCompareRequest;
import com.shashi.StockPriceApplication.dto.StockPriceDto;

import java.text.ParseException;
import java.util.List;

public interface StockPriceService 
{
	public List<StockPriceDto> findAll();
	public StockPriceDto findById(String id);
	public void deleteById(String id);
	public List<StockPriceDto> save(List<StockPriceDto> stockPriceDtos);
	public StockPriceDto update(StockPriceDto stockPriceDto);
	public List<StockPriceDto> getStockPricesForCompanyComparison(CompanyCompareRequest compareRequest)throws ParseException;
	public List<StockPriceDto> getStockPricesForSectorComparison(SectorCompareRequest compareRequest)throws ParseException;
}
