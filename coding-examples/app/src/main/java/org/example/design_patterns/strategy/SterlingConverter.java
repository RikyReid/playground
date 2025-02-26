package org.example.design_patterns.strategy;

class SterlingConverter {
    private final Currency currency;

    SterlingConverter(Currency currency) {
        this.currency = currency;
    }

    double convert(double sterling) {
        return currency.exchangeRate() * sterling;
    }
}
