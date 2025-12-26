package com.firstJobApp.JobCompanyApp.Company.Impl;

import com.firstJobApp.JobCompanyApp.Company.CompanyRepository;
import com.firstJobApp.JobCompanyApp.Company.Company;
import com.firstJobApp.JobCompanyApp.Company.CompanyService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImp implements CompanyService {

    private final CompanyRepository companyRepository;

    public CompanyServiceImp(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Company> getAllCompany() {
        return companyRepository.findAll();
    }

    @Override
    public Company getCompanyById(Long id) {
        return companyRepository.findById(id).orElse(null);
    }

    @Override
    public void createCompany(Company company) {
        companyRepository.save(company);
    }

    @Override
    public boolean updateCompany(Long id, Company company) {
        Optional<Company> company1 = companyRepository.findById(id);
        if(company1.isPresent()){
            Company companyData = company1.get();
            companyData.setCompanyName(company.getCompanyName());
            companyData.setCompanyLocation(company.getCompanyLocation());
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteCompany(long id) {
        try{
            companyRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
