package com.example.adautomation;

import com.example.adautomation.model.AdPerformance;
import com.example.adautomation.model.StartupInfo;
import com.example.adautomation.service.AIAnalyzer;
import com.example.adautomation.service.AdOptimizer;
import com.example.adautomation.service.GoogleAdsManager;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StartupAdAutomationApplication {
    public static void main(String[] args) {
    	  SpringApplication.run(StartupAdAutomationApplication.class, args);
          System.out.println("Startup Ad Automation Application is running...");
    	 StartupInfo startupInfo = new StartupInfo("Startup XYZ", "AI-driven solutions", 50000, "AI-driven solutions for the healthcare industry.");

        // AI-Generated Strategy
        AIAnalyzer aiAnalyzer = new AIAnalyzer();
        String aiStrategy = aiAnalyzer.analyzeWithAI(startupInfo);
       System.out.println("Ai stratergy will be:"+aiStrategy);
        // Create Campaign
       
        GoogleAdsManager adsManager = new GoogleAdsManager();
        adsManager.createAdCampaign(aiStrategy);

        // Fetch Ad Performance Data
        List<AdPerformance> adPerformances = adsManager.fetchAdPerformanceData();

        // Optimize Ads
        AdOptimizer optimizer = new AdOptimizer();
        optimizer.optimizeCampaigns(adPerformances);
    }
}
