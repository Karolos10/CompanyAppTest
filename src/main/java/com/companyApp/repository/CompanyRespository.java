package com.companyApp.repository;

import com.companyApp.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRespository extends JpaRepository<Company, Long> {

    Company findByCodeCompany(String codeCompany);
}
