package com.example.adautomation.model;

import lombok.Data;

@Data
public class AdPerformance {
    private String adId;
    private int impressions;
    private int clicks;
    private double conversionRate;
    private double costPerClick;

    public AdPerformance(String adId, int impressions, int clicks, double conversionRate, double costPerClick) {
        this.adId = adId;
        this.impressions = impressions;
        this.clicks = clicks;
        this.conversionRate = conversionRate;
        this.costPerClick = costPerClick;
    }

    public String getAdId() { return adId; }
    public int getImpressions() { return impressions; }
    public int getClicks() { return clicks; }
    public double getConversionRate() { return conversionRate; }
    public double getCostPerClick() { return costPerClick; }

    @Override
    public String toString() {
        return String.format("Ad ID: %s, Impressions: %d, Clicks: %d, Conversion Rate: %.2f%%, CPC: $%.2f",
            adId, impressions, clicks, conversionRate * 100, costPerClick);
    }
}
