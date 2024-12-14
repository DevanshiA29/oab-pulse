package com.example.adautomation.model;

import lombok.Data;

@Data
public class StartupInfo {
    private String name;
    private String industry;
    private int budget;
    private String description;

    public StartupInfo(String name, String industry, int budget, String description) {
        this.name = name;
        this.industry = industry;
        this.budget = budget;
        this.description = description;
    }

    public String getName() { return name; }
    public void setName(String name) {
        this.name = name;}
    
    public String getIndustry() { return industry; }
    
    public void setIndustry(String industry) {
        this.industry = industry;
    }
    public int getBudget() { return budget; }
    
    public void setBudget(int budget ) {
        this.budget = budget;
    }
    
    public String getDescription() { return description; }
    
    public void setDescription(String description) {
        this.description = description;
    }
    public StartupInfo() {
        // Default constructor for frameworks like Spring Boot
    }
    public String toString() {
        return "StartupInfo{" +
                "name='" + name + '\'' +
                ", industry='" + industry + '\'' +
                ", budget=" + budget +
                ", description='" + description + '\'' +
                '}';
    }
    
}
