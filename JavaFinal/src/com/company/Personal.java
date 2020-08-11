package com.company;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;

public class Personal extends LoanP implements Generate {
    private double interestRate = 6;
    private static DecimalFormat df = new DecimalFormat("0.00");

    public Personal(String number, String name, double amount, int years, String type) {
        super(number, name, amount, years, type);
    }

    @Override
    public ArrayList<double[]> generateTable() {

        ArrayList<double[]> amortization = new ArrayList<>();
        double monthlyRate = this.interestRate / (12 * 100);
        double termInMonths = this.numberOfYears * 12;
        int i = 0;
        double monthlyPrincipal = 0;
        double monthlyInterest = 0;
        double monthlyPayment = 0;
        double balance = this.loanAmount;
        amortization.add(new double[]{i, monthlyPrincipal, monthlyInterest, monthlyPayment, balance});

        while(i < termInMonths) {

            i++;
            monthlyInterest = roundAvoid(balance * monthlyRate, 2);
            if(i == 1) {
                monthlyPayment = roundAvoid(monthlyInterest / (1 - Math.pow(1 + monthlyRate, -termInMonths)), 2);
            }
            monthlyPrincipal = roundAvoid(monthlyPayment - monthlyInterest, 2);
            balance = roundAvoid(balance - monthlyPrincipal, 2);
            amortization.add(new double[]{i, monthlyPrincipal, monthlyInterest, monthlyPayment, balance});
        }

        return amortization;
    }
}