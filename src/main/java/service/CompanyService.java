package service;

import entities.Company;

import java.util.List;

public interface CompanyService {
    List<Company> findAll();

    Company findById(Long id);
}
