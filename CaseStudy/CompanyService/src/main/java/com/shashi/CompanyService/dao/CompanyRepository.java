package com.shashi.CompanyService.dao;

import com.shashi.CompanyService.model.Company;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface CompanyRepository extends MongoRepository<Company, String> {
    public Optional<Company> findById(String id);
    public List<Company> findByNameIgnoreCaseContaining(String pattern);
    public Company findByName(String name);
    public Company findByCode(String code);
}
