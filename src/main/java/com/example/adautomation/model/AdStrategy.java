package com.example.adautomation.model;

import lombok.Data;

@Data
public class AdStrategy {
    private String audience;
    private String campaignType;
    private int budget;

    public AdStrategy(String audience, String campaignType, int budget) {
        this.audience = audience;
        this.campaignType = campaignType;
        this.budget = budget;
    }

    public String getAudience() { return audience; }
    public String getCampaignType() { return campaignType; }
    public int getBudget() { return budget; }
}
