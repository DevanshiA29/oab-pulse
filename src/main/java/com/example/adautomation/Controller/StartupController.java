package com.example.adautomation.Controller;

import com.example.adautomation.model.AdPerformance;
import com.example.adautomation.model.StartupInfo;
import com.example.adautomation.service.AIAnalyzer;
import com.example.adautomation.service.AdOptimizer;
import com.example.adautomation.service.GoogleAdsManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/startup")
public class StartupController {

    
    @Autowired
    private AIAnalyzer aiAnalyzer;
  
    
    
    @Autowired
    private GoogleAdsManager googleAdsManager;

    @Autowired
    private AdOptimizer adOptimizer;

    // Endpoint to analyze startup info and generate ad strategy
    @PostMapping("/analyze")
    public String analyzeStartup(@RequestBody StartupInfo startupInfo) {
        return aiAnalyzer.analyzeWithAI(startupInfo);
    }

    // Endpoint to create an ad campaign
    @PostMapping("/create-campaign")
    public String createCampaign(@RequestBody String strategy) {
        googleAdsManager.createAdCampaign(strategy);
        return "Campaign created successfully!";
    }

    // Endpoint to fetch ad performance data
    @GetMapping("/performance")
    public List<AdPerformance> getAdPerformance() {
        return googleAdsManager.fetchAdPerformanceData();
    }

    // Endpoint to optimize ad campaigns
    @PostMapping("/optimize")
    public String optimizeCampaigns() {
        List<AdPerformance> adPerformances = googleAdsManager.fetchAdPerformanceData();
        adOptimizer.optimizeCampaigns(adPerformances);
        return "Optimization suggestions generated and applied.";
    }
}
