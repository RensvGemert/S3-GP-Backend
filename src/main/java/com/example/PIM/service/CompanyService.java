package com.example.PIM.service;

import com.example.PIM.model.Company;
import com.example.PIM.model.Product;
import com.example.PIM.model.User;
import com.example.PIM.repositories.ICompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
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

    public void createCompany(Company company){
        if(company.getCompanyName() != "" || company.getCompanyDescription()!= "") {
            companyRepository.save(company);
        }
    }


    public void deleteCompany(int companyId){
        boolean exists = companyRepository.existsById(companyId);
        if(!exists){
            throw new IllegalStateException("User with id: " + companyId + " does not exist");
        }
        companyRepository.deleteById(companyId);
    }

    @Transactional
    public void updateCompany(int id, String name, String description, boolean companyRole) {
        Company company = companyRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("product with id: " + id + " not found!"));
        if(name != null &&
                name.length() > 0 &&
                !Objects.equals(company.getCompanyName(), name)) {
            company.setCompanyName(name);
        }
        if(description != null &&
                description.length() > 0 &&
                !Objects.equals(company.getCompanyDescription(), description)) {
            company.setCompanyDescription(description);
        }
        if(!Objects.equals(company.isRole(), companyRole)) {
            company.setRole(companyRole);
        }
    }


}
