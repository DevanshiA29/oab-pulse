package com.example.adautomation.service;

import org.springframework.stereotype.Service;

import com.example.adautomation.model.StartupInfo;

@Service
public class StartupAnalyzer {
    public String analyzeTargetAudience(StartupInfo info) {
        if (info.getDescription().toLowerCase().contains("business")) {
            return "B2B Clients";
        }
        return "General Consumers";
    }

    public String generateIndustryInsights(StartupInfo info) {
        return "Insight: Software development is trending with AI integration.";
    }
}
