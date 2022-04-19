package com.example.PIM.service;

import com.example.PIM.model.Company;
import com.example.PIM.model.Product;
import com.example.PIM.repositories.ICompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {

    private final ICompanyRepository companyRepository;

    @Autowired
    public CompanyService(ICompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public List<Company> getCompanies(){
        return companyRepository.findAll();

    }

    public Optional<Company> getCompanyById(int id){
        return companyRepository.findById(id);
    }

    public void createCompany(Company newCompany)
    {
        this.companyRepository.save(newCompany);
    }


}
