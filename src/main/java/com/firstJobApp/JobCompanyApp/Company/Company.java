package com.firstJobApp.JobCompanyApp.Company;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.firstJobApp.JobCompanyApp.Job.Job;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long companyId;
    private String companyName;
    private String companyLocation;

    @JsonIgnore
    @OneToMany(mappedBy = "company")
    private List<Job> jobs;

    public Company() {
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyLocation() {
        return companyLocation;
    }

    public void setCompanyLocation(String companyLocation) {
        this.companyLocation = companyLocation;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> job) {
        this.jobs= job;
    }
}
