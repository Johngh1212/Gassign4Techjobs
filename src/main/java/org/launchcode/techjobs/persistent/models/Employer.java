package org.launchcode.techjobs.persistent.models;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
// added required imported statements
import jakarta.persistence.OneToMany;
import jakarta.persistence.JoinColumn;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Employer extends AbstractEntity {

    @NotBlank(message = "Location cannot be empty")
    @Size(max = 100, message = "Location must be less than 100 characters")
    private String location;

    @OneToMany
    @JoinColumn(name = "employer_id")  // foreign key column in Job table
    private List<Job> jobs = new ArrayList<>();

    public Employer() {
        // No-arg constructor required by Hibernate
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {

        this.location = location;
    }

    public List<Job> getJobs() {

        return jobs;
    }

    public void setJobs(List<Job> jobs) {

        this.jobs = jobs;
    }
}
