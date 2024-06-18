package org.launchcode.techjobs.persistent.controllers;

import jakarta.validation.Valid;
import org.launchcode.techjobs.persistent.models.Job;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;


// added imported statements
import org.launchcode.techjobs.persistent.models.Employer;
import org.launchcode.techjobs.persistent.models.Skill;
import org.launchcode.techjobs.persistent.models.data.EmployerRepository;
import org.launchcode.techjobs.persistent.models.data.JobRepository;
import org.launchcode.techjobs.persistent.models.data.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

///**
// * Created by LaunchCode
// */

@Controller
//public class HomeController {
//
//    @Autowired
//    private EmployerRepository employerRepository;
//
//    @Autowired
//    private SkillRepository skillRepository;
//
//    @Autowired
//    private JobRepository jobRepository;
//
//    @RequestMapping("/")
//    public String index(Model model) {
//        model.addAttribute("title", "MyJobs");
//        return "index";
//    }
//
//
//
//    @GetMapping("add")
//    public String displayAddJobForm(Model model) {
//        model.addAttribute("title", "Add Job");
//        model.addAttribute(new Job());
//        model.addAttribute("employers", employerRepository.findAll());
//        model.addAttribute("skills", skillRepository.findAll());
//        return "add";
//    }
//
//    @PostMapping("add")
//    public String processAddJobForm(@ModelAttribute @Valid Job newJob,
//                                    Errors errors, Model model, @RequestParam int employerId,
//                                    @RequestParam List<Integer> skills) {
//
//        if (errors.hasErrors()) {
//            model.addAttribute("title", "Add Job");
//            model.addAttribute("employers", employerRepository.findAll());
//            model.addAttribute("skills", skillRepository.findAll());
//            return "add";
//        }
//
//        Optional<Employer> employerOptional = employerRepository.findById(employerId);
//        if (!employerOptional.isPresent()) {
//            // Handle the case where the employer is not found
//            return "redirect:/add";
//        }
//
//        Employer employer = employerOptional.get();
//        newJob.setEmployer(employer);
//
//        List<Skill> skillObjs = (List<Skill>) skillRepository.findAllById(skills);
//        newJob.setSkills(skillObjs);
//
//        jobRepository.save(newJob);
//
//        return "redirect:/";
//    }
//
//    @GetMapping("view/{jobId}")
//    public String displayViewJob(Model model, @PathVariable int jobId) {
//        Optional<Job> jobOptional = jobRepository.findById(jobId);
//        if (!jobOptional.isPresent()) {
//            // Handle the case where the job is not found
//            return "redirect:/";
//        }
//
//        Job job = jobOptional.get();
//        model.addAttribute("job", job);
//        return "view";
//    }
//}

public class HomeController {

    @Autowired
    private EmployerRepository employerRepository;

    @Autowired
    private SkillRepository skillRepository;

    @Autowired
    private JobRepository jobRepository;

//    @RequestMapping("add")
//    public String displayAddJobForm(Model model) {
//        model.addAttribute("employers", employerRepository.findAll());
//        model.addAttribute("skills", skillRepository.findAll());
//        model.addAttribute(new Job());
//        return "add";
//    }
//
//    @RequestMapping(value = "add", method = RequestMethod.POST)
//    public String processAddJobForm(@ModelAttribute Job newJob, Errors errors, Model model,
//                                    @RequestParam int employerId,
//                                    @RequestParam List<Integer> skills) {
//
//        if (errors.hasErrors()) {
//            model.addAttribute("employers", employerRepository.findAll());
//            model.addAttribute("skills", skillRepository.findAll());
//            return "add";
//        }
//
//        Employer employer = employerRepository.findById(employerId).orElse(null);
//        newJob.setEmployer(employer);
//
//        List<Skill> skillObjs = (List<Skill>) skillRepository.findAllById(skills);
//        newJob.setSkills(skillObjs);
//
//        jobRepository.save(newJob);
//
//        return "redirect:";
//    }
//}


@RequestMapping(value = "/add", method = RequestMethod.GET) // Added leading slash for consistent mapping
public String displayAddJobForm(Model model) {

    model.addAttribute("title", "Add Job");
    model.addAttribute("job", new Job());
    model.addAttribute("employers", employerRepository.findAll());
    model.addAttribute("skills", skillRepository.findAll());
    return "add";
}

@RequestMapping(value = "/add", method = RequestMethod.POST) // Added leading slash for consistent mapping
public String processAddJobForm(@ModelAttribute @Valid Job job,
                                Errors errors, Model model,
                                @RequestParam int employerId,
                                @RequestParam List<Integer> skills) {

    if (errors.hasErrors()) {
        model.addAttribute("employers", employerRepository.findAll());
        model.addAttribute("skills", skillRepository.findAll());
        return "add";
    }

    Employer employer = employerRepository.findById(employerId).orElse(null);
    job.setEmployer(employer);

    List<Skill> skillObjs = (List<Skill>) skillRepository.findAllById(skills);
    job.setSkills(skillObjs);

    jobRepository.save(job);

    return "redirect:/"; // Redirect to home page after successful submission
}

@GetMapping("/view/{jobId}") // Added leading slash for consistent mapping
public String displayViewJob(Model model, @PathVariable int jobId) {
    Optional<Job> jobOptional = jobRepository.findById(jobId);
    if (jobOptional.isPresent()) {
        Job job = jobOptional.get();
        model.addAttribute("job", job);
        return "view";
    } else {
        return "redirect:/"; // Redirect to home page if job is not found
    }
}
}

