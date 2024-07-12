package com.vasev.titanic_statistics_border.model;

public class PassengerStats {
    private double totalFare;
    private long totalWithRelatives;
    private long totalSurvived;

    public double getTotalFare() {
        return totalFare;
    }

    public void setTotalFare(double totalFare) {
        this.totalFare = totalFare;
    }

    public long getTotalWithRelatives() {
        return totalWithRelatives;
    }

    public void setTotalWithRelatives(long totalWithRelatives) {
        this.totalWithRelatives = totalWithRelatives;
    }

    public long getTotalSurvived() {
        return totalSurvived;
    }

    public void setTotalSurvived(long totalSurvived) {
        this.totalSurvived = totalSurvived;
    }
}