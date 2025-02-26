package org.example.enums.interface_pattern;

public enum ModernPaymentMethod implements PaymentMethod {
    CRYPTO("Cryptocurrency") {
        @Override
        public boolean isModern() {
            return true;
        }
    },
    PAYPAL("PayPal") {
        @Override
        public boolean isModern() {
            return true;
        }
    };

    private final String description;

    ModernPaymentMethod(String description) {
        this.description = description;
    }

    @Override
    public String description() {
        return description;
    }
}
