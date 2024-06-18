package org.launchcode.techjobs.persistent.controllers;

import jakarta.validation.Valid;
import org.launchcode.techjobs.persistent.models.Employer;
import org.launchcode.techjobs.persistent.models.data.EmployerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/employers") //added /employers
public class EmployerController {

// @Autowired allows access to interact with database
    @Autowired
    private EmployerRepository employerRepository;


    // add @GetMapping("/") routing annotation that contains a value which routes to the root URl.
    @GetMapping("/")
    public String index(Model model) {
        Iterable<Employer> employers = employerRepository.findAll();
        model.addAttribute("employers", employers);
        return "employers/index";
    }

    @GetMapping("/add")  //added /
    public String displayAddEmployerForm(Model model) {
        model.addAttribute(new Employer());
        return "employers/add";
    }


    // modify to add save a new employer
    @PostMapping("/add")  //added /
    public String processAddEmployerForm(@ModelAttribute @Valid Employer newEmployer,
                                         Errors errors, Model model) {

        if (errors.hasErrors()) {
            return "employers/add";
        }

        employerRepository.save(newEmployer);

        return "redirect:/employers";
    }


    // modify to view details of a specific employer
    @GetMapping("/view/{employerId}") //added /view
    public String displayViewEmployer(Model model, @PathVariable int employerId) {

        Optional<Employer> optEmployer = employerRepository.findById(employerId);
        if (optEmployer.isPresent()) {
            Employer employer = optEmployer.get();
            model.addAttribute("employer", employer);
            return "employers/view";
        } else {
            return "redirect:/employers/"; //added employers/
        }
    }

}
