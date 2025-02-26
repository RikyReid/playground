package org.example.enums.interface_pattern;

public enum BasicMethodPayment implements PaymentMethod {
    CREDIT_CARD("Credit Card"),
    DEBIT_CARD("Debit Card"),
    CASH("Cash");

    private final String description;

    BasicMethodPayment(String description) {
        this.description = description;
    }

    @Override
    public String description() {
        return description;
    }
}
