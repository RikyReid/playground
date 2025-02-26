package org.example.design_patterns.strategy;

public class Euro implements Currency {
    @Override
    public double exchangeRate() {
        return 0.05;
    }
}
