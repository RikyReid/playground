package org.example.enums.interface_pattern;

public enum CustomPaymentMethod implements PaymentMethod {
    GIFT_CARD("Cryptocurrency") {
        @Override
        public boolean isModern() {
            return false;
        }
    };

    private final String description;

    CustomPaymentMethod(String description) {
        this.description = description;
    }

    @Override
    public String description() {
        return description;
    }
}
