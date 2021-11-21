package com.shashi.StockPriceApplication.dao;

import com.shashi.StockPriceApplication.model.StockPrice;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockPriceRepository extends MongoRepository<StockPrice, String>
{
	public List<StockPrice> findByCompanyCodeAndStockExchangeName(String companyCode, String stockExchangeName);
}
