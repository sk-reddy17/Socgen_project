package com.shashi.CompanyService.service;

import com.shashi.CompanyService.dto.IpoDto;

import java.util.List;

public interface IpoService
{
    public List<IpoDto> findAll();
    public IpoDto findById(String id);
    public IpoDto save(IpoDto ipoDto);
    public IpoDto update(IpoDto ipoDto);
    public void deleteById(String id);
}