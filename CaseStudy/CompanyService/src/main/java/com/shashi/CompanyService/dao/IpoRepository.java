package com.shashi.CompanyService.dao;

import com.shashi.CompanyService.model.Ipo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IpoRepository extends MongoRepository<Ipo, String> {
}
