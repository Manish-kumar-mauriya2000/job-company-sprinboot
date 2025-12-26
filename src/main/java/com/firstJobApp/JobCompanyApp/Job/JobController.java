package com.firstJobApp.JobCompanyApp.Job;

import com.firstJobApp.JobCompanyApp.Job.Impl.JobServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/job")
public class JobController {

    private final JobServiceImpl jobService;

    public JobController(JobServiceImpl jobService) {
        this.jobService = jobService;
    }

    @PostMapping("createJob")
    public ResponseEntity<?> createJob(@RequestBody Job job){
        jobService.createJob(job);
        return new ResponseEntity<>("Job Created Successfully", HttpStatus.OK);
    }

    @GetMapping("allJobs")
    public ResponseEntity<List<Job>> findAllJobs(){
        return  new ResponseEntity<>(jobService.getAllJobs(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> jobById(@PathVariable Long id){
        Job data=jobService.getJobById(id);
        if(data!=null){
            return new ResponseEntity<>(jobService.getJobById(id),HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Job Not Found!!!",HttpStatus.NOT_FOUND);
        }

    }

    @PutMapping("updateJob/{id}")
    public ResponseEntity<?> updateJob(@PathVariable Long id,@RequestBody Job job){
        if(jobService.updateJob(id,job)){
            return new ResponseEntity<>("Job Updated Successfully!!",HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Job Not updated/Not Found!!",HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> removeJob(@PathVariable Long id){
        if(jobService.deleteJob(id)){
            return new ResponseEntity<>("Job Deleted Successfully!!",HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Job Not found/Something went wrong!!",HttpStatus.NOT_FOUND);
        }

    }
}
