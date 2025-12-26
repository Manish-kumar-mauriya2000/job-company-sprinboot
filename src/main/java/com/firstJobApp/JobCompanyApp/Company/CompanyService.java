package com.firstJobApp.JobCompanyApp.Company;

import java.util.List;


public interface CompanyService {
    List<Company> getAllCompany();
    Company getCompanyById(Long id);
    void createCompany(Company company);
    boolean updateCompany(Long id,Company company);
    boolean deleteCompany(long id);
}
