package com.company;

public class LoanP {
    String clientNumber;
    String clientName;
    double loanAmount;
    int numberOfYears;
    String loanType;

    public LoanP(String number, String name, double amount, int years, String type) {
        this.clientNumber = number;
        this.clientName = name;
        this.loanAmount = amount;
        this.numberOfYears = years;
        this.loanType = type;
    }

    public static double roundAvoid(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }
}