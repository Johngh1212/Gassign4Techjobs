package org.launchcode.techjobs.persistent.models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.List;

//added imported statements
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.persistence.ManyToMany;  // Import ManyToMany annotation from jakarta.persistence
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;



@Entity
//public class Job {
//
//    @Id
//    @GeneratedValue
//    private int id;
//
//    private String name;
//    private String employer;
//    private String skills;
//
//
//    public Job() {
//    }
//
//    // Initialize the id and value fields.
//    public Job(String anEmployer, String someSkills) {
//        super();
//        this.employer = anEmployer;
//        this.skills = someSkills;
//    }
//
//    // Getters and setters.
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getEmployer() {
//        return employer;
//    }
//
//    public void setEmployer(String employer) {
//        this.employer = employer;
//    }
//
//    public String getSkills() {
//        return skills;
//    }
//
//    public void setSkills(String skills) {
//        this.skills = skills;
//    }
//
//}



//public class Job extends AbstractEntity {
//
//    private String employer;
//    private String skills;
//
//    public Job() {
//    }
//
//    // Initialize the employer and skills fields.
//    public Job(String anEmployer, String someSkills) {
//        super();
//        this.employer = anEmployer;
//        this.skills = someSkills;
//    }
//
//    // Getters and setters.
//
//    public String getEmployer() {
//        return employer;
//    }
//
//    public void setEmployer(String employer) {
//        this.employer = employer;
//    }
//
//    public String getSkills() {
//        return skills;
//    }
//
//    public void setSkills(String skills) {
//        this.skills = skills;
//    }
//}


//public class Job extends AbstractEntity {
//
//    @ManyToOne
//    @NotNull(message = "Employer is required")
//    private Employer employer;
//
//    @ManyToMany
//    @JoinTable(
//            name = "job_skill",
//            joinColumns = @JoinColumn(name = "job_id"),
//            inverseJoinColumns = @JoinColumn(name = "skill_id")
//    )
//    private List<Skill> skills;
//
//    public Job() {
//        // No-arg constructor required by Hibernate
//    }
//
//    // Initialize the employer and skills fields.
//    public Job(Employer anEmployer, List<Skill> someSkills) {
//        super();
//        this.employer = anEmployer;
//        this.skills = someSkills;
//    }
//
//    // Getters and setters.
//    public Employer getEmployer() {
//        return employer;
//    }
//
//    public void setEmployer(Employer employer) {
//        this.employer = employer;
//    }
//
//    public List<Skill> getSkills() {
//        return skills;
//    }
//
//    public void setSkills(List<Skill> skills) {
//        this.skills = skills;
//    }
//}

public class Job extends AbstractEntity {

    @ManyToOne
    @NotNull(message = "Employer is required")
    private Employer employer;

    @ManyToMany
//    @JoinTable(
//            name = "job_skill",
//            joinColumns = @JoinColumn(name = "job_id"),
//            inverseJoinColumns = @JoinColumn(name = "skill_id")
//    )
    private List<Skill> skills;

    public Job() {
        // No-arg constructor required by Hibernate
    }

    public Job(Employer employer, List<Skill> skills) {
        super();
        this.employer = employer;
        this.skills = skills;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }
}