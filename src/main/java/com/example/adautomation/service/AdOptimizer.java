package com.example.adautomation.service;

import com.example.adautomation.model.AdPerformance;
import com.example.adautomation.util.AIHelper;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class AdOptimizer {
    public void optimizeCampaigns(List<AdPerformance> adPerformances) {
        for (AdPerformance performance : adPerformances) {
            String optimizationPrompt = String.format(
                "Optimize this ad campaign:\nAd ID: %s\nImpressions: %d\nClicks: %d\n" +
                "Conversion Rate: %.2f\nCost Per Click: %.2f",
                performance.getAdId(), performance.getImpressions(), performance.getClicks(),
                performance.getConversionRate(), performance.getCostPerClick()
            );

            String optimizationSuggestion = AIHelper.getAIAnalysis(optimizationPrompt);
            System.out.println("Optimization Suggestion for Ad ID " + performance.getAdId() + ":\n" + optimizationSuggestion);
        }
    }

    public AdPerformance simulateAdPerformance() {
        // Simulate fetching data from Google Ads API
        return new AdPerformance("AD123", 1000, 120, 0.05, 1.25);
    }
}
