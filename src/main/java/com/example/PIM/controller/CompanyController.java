package com.example.PIM.controller;
import com.example.PIM.model.Company;
import com.example.PIM.model.Product;
import com.example.PIM.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/company")
public class CompanyController {

    private final CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping
    public List<Company> getUsers(){
        return companyService.getCompanies();
    }

    @PostMapping
    public ResponseEntity<String> createCompany(@RequestBody Company company) {
        companyService.createCompany(company);
        return ResponseEntity.status(HttpStatus.OK)
                .body("{ \"id\": "+ company.getCompanyId() + " }");
    }

    @GetMapping("/{id}")
    public Optional<Company> getCompanyById(@PathVariable int id) {
        return companyService.getCompanyById(id);
    }
}
