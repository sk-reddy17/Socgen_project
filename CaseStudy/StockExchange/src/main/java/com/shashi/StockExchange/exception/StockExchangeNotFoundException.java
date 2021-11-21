package com.shashi.StockExchange.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StockExchangeNotFoundException extends Throwable
{
	private String message;
}
