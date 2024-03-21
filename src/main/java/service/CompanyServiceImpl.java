package service;

import dao.CompanyRepository;
import entities.Company;

import java.util.List;
import java.util.Optional;

public class CompanyServiceImpl implements CompanyService {

    private CompanyRepository companyRepository;

    @Override
    public List<Company> findAll() {
        return companyRepository.findAll();
    }

    @Override
    public Company findById(Long id) {
        Optional<Company> search = companyRepository.findById(id);
        Company company = null;
        if (search.isPresent()) {
            company = search.get();
        } else {
            throw new RuntimeException("Empresa de ID: " + id + " não encontrada");
        }
        return company;
    }

}
