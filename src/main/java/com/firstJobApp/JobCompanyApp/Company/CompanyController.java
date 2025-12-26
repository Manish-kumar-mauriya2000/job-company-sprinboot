package com.firstJobApp.JobCompanyApp.Company;

import com.firstJobApp.JobCompanyApp.Company.Impl.CompanyServiceImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {
    private CompanyServiceImp companyServiceImp;

    public CompanyController(CompanyServiceImp companyServiceImp) {
        this.companyServiceImp = companyServiceImp;
    }

    @PostMapping("createCompany")
    public ResponseEntity<?> createCompany(@RequestBody Company company){
        companyServiceImp.createCompany(company);
        return new ResponseEntity<>("Company Created Successfully", HttpStatus.OK);
    }

    @GetMapping("companies")
    public ResponseEntity<List<Company>> findAllCompany(){
        return  new ResponseEntity<>(companyServiceImp.getAllCompany(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> companyById(@PathVariable Long id){
        Company data=companyServiceImp.getCompanyById(id);
        if(data!=null){
            return new ResponseEntity<>(companyServiceImp.getCompanyById(id),HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Job Not Found!!!",HttpStatus.NOT_FOUND);
        }

    }

    @PutMapping("updateCompany/{id}")
    public ResponseEntity<?> updateCompany(@PathVariable Long id,@RequestBody Company company){
        if(companyServiceImp.updateCompany(id,company)){
            return new ResponseEntity<>("Job Updated Successfully!!",HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Job Not updated/Not Found!!",HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> removeJob(@PathVariable Long id){
        if(companyServiceImp.deleteCompany(id)){
            return new ResponseEntity<>("Job Deleted Successfully!!",HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Job Not found/Something went wrong!!",HttpStatus.NOT_FOUND);
        }

    }
}
