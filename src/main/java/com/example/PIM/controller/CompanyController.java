package com.example.PIM.controller;
import com.example.PIM.model.Company;
import com.example.PIM.model.Product;
import com.example.PIM.model.User;
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
    public List<Company> getCompanies(){
        return companyService.getCompanies();
    }

    @PostMapping
    public ResponseEntity<String> createCompany(@RequestBody Company company) {
        companyService.createCompany(company);
        return ResponseEntity.status(HttpStatus.OK)
                .body("{ \"id\": "+ company.getId() + " }");
    }

    @GetMapping("/{id}")
    public Optional<Company> getCompanyById(@PathVariable int id) {
        return companyService.getCompanyById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCompany(@PathVariable("id") int id) {
        companyService.deleteCompany(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body("{ \"id\": "+ id + " }");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCompany(@PathVariable("id") int id, @RequestBody Company company) {
        companyService.updateCompany(id, company.getName(), company.getDescription(), company.isRole());
        return ResponseEntity.status(HttpStatus.OK)
                .body("{ \"id\": "+ id + " }");
    }
}
