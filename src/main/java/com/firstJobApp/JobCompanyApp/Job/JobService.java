package com.firstJobApp.JobCompanyApp.Job;


import java.util.List;


public interface JobService {
    List<Job> getAllJobs();
    void createJob(Job job);
    Job getJobById(Long id);
    boolean updateJob(Long id,Job job);
    boolean deleteJob(Long id);
}
