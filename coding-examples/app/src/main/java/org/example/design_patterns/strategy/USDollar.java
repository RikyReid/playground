package org.example.design_patterns.strategy;

public class USDollar implements Currency {
    @Override
    public double exchangeRate() {
        return 0.25;
    }
}
