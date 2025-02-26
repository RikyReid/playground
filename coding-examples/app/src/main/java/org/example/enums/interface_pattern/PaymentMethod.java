package org.example.enums.interface_pattern;

public sealed interface PaymentMethod
permits BasicMethodPayment, ModernPaymentMethod, CustomPaymentMethod {
    String description();

    default boolean isModern() {
        return false;
    }
}
