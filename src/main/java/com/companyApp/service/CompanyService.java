package com.companyApp.service;

import com.companyApp.model.Company;
import com.companyApp.repository.CompanyRespository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class CompanyService {

    private final CompanyRespository companyRepository;

    public CompanyService(CompanyRespository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    public Optional<Company> getCompanyById(Long id) {
        return companyRepository.findById(id);
    }

    public Optional<Company> getCompanyByCode(String codeCompany) {
        return Optional.ofNullable(companyRepository.findByCodeCompany(codeCompany));
    }

    public Company createCompany(Company company) {
        return companyRepository.save(company);
    }

    public Optional<Company> updateCompany(Long id, Company companyDetails) {
        return companyRepository.findById(id)
                .map(existingCompany -> {
                    existingCompany.setNameCompany(companyDetails.getNameCompany());
                    existingCompany.setCodeCompany(companyDetails.getCodeCompany());
                    existingCompany.setDescripcionCompany(companyDetails.getDescripcionCompany());
                    return companyRepository.save(existingCompany);
                });
    }

    public void deleteCompany(Long id) {
        companyRepository.deleteById(id);
    }

    public Map<String, String> getCompanyDetails(String codeCompany) {
        return getCompanyByCode(codeCompany)
                .map(company -> Map.of(
                        "name", company.getNameCompany(),
                        "code", company.getCodeCompany(),
                        "description", company.getDescripcionCompany()
                ))
                .orElse(Map.of("error", "Company not found"));
    }
}
