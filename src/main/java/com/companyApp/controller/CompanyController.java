package com.companyApp.controller;

import com.companyApp.model.Company;
import com.companyApp.repository.CompanyRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/company")
public class CompanyController {

    @Autowired
    private CompanyRespository companyRespository;

    @GetMapping("/all")
    public List<Company> getAllCompanies() {
        return companyRespository.findAll();
    }

    @GetMapping("/{code}")
    public Company getCompanyByCode(@PathVariable Long code) {
        return companyRespository.findById(code).orElse(null);
    }
    
    @PostMapping("/add")
    public Company addCompany(@RequestBody Company company) {
        return companyRespository.save(company);
    }

    @PutMapping("/update/{code}")
    public Company updateCompany(@PathVariable Long code, @RequestBody Company company) {
        Company existingCompany = companyRespository.findById(code).orElse(null);
        if (existingCompany != null) {
            existingCompany.setNameCompany(company.getNameCompany());
            existingCompany.setCodeCompany(company.getCodeCompany());
            existingCompany.setDescripcionCompany(company.getDescripcionCompany());
            return companyRespository.save(existingCompany);
        }
        return null;
    }

    @DeleteMapping("/delete/{code}")
    public void deleteCompany(@PathVariable Long code) {
        companyRespository.deleteById(code);
    }

    @GetMapping("/details/{codeCompany}")
    public Map<String, Object> getCompanyDetails(@PathVariable String codeCompany) {
        Company company = companyRespository.findByCodeCompany(codeCompany);
        Map<String, Object> response = new HashMap<>();
        if (company != null) {
            return Map.of(
                    "name", company.getNameCompany(),
                    "code", company.getCodeCompany(),
                    "description", company.getDescripcionCompany()
            );
        }
        return Map.of("error", "Company not found");
    }
}
