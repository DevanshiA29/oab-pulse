package com.example.adautomation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.adautomation.model.StartupInfo;
import com.example.adautomation.util.AIHelper;

@Service
public class AIAnalyzer {
    @Autowired
    private AIHelper aiHelper;

    public String analyzeWithAI(StartupInfo startupInfo) {
        String prompt = String.format(
            "Analyze this startup's details and suggest an precise advertisement strategy in points:\n" +
            "Name: %s\nIndustry: %s\nBudget: %d\nDescription: %s",
            startupInfo.getName(), startupInfo.getIndustry(), startupInfo.getBudget(), startupInfo.getDescription()
        );

        return aiHelper.getAIAnalysis(prompt);
    }
}
