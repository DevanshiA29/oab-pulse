package com.example.adautomation.service;

import org.springframework.stereotype.Service;

@Service
public class StrategyGenerator {
    public String generateAdStrategy(String audience, String industryInsights, int budget) {
        if (budget > 3000) {
            return "Premium Campaign targeting " + audience + " with industry insights: " + industryInsights;
        } else {
            return "Basic Campaign targeting " + audience;
        }
    }
}
