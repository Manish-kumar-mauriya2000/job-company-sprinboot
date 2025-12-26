package com.firstJobApp.JobCompanyApp.Job.Impl;

import com.firstJobApp.JobCompanyApp.Job.Job;
import com.firstJobApp.JobCompanyApp.Job.JobRepository;
import com.firstJobApp.JobCompanyApp.Job.JobService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImpl implements JobService {

    JobRepository jobRepository;

    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    @Override
    public void createJob(Job job) {
        jobRepository.save(job);
    }

    @Override
    public Job getJobById(Long id) {
        return jobRepository.findById(id).orElse(null);
    }

    @Override
    public boolean updateJob(Long id, Job job) {
        Optional<Job> optionalJob = jobRepository.findById(id);
        if(optionalJob.isPresent()){
            Job jobData = optionalJob.get();
            jobData.setJobTitle(job.getJobTitle());
            jobData.setJobDescription(job.getJobDescription());
            jobData.setMinSalary(job.getMinSalary());
            jobData.setMaxSalary(job.getMaxSalary());
            jobData.setLocation(job.getLocation());
            return true;
        }
        return false;

    }

    @Override
    public boolean deleteJob(Long id) {
        try{
            jobRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
