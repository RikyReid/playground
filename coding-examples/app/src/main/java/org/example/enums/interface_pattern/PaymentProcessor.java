package org.example.enums.interface_pattern;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.example.enums.interface_pattern.ModernPaymentMethod.CRYPTO;

public class PaymentProcessor {
    private static final Set<PaymentMethod> ACCEPTED_METHODS;

    static {
        ACCEPTED_METHODS = Stream.concat(
                Arrays.stream(BasicMethodPayment.values()),
                Arrays.stream(ModernPaymentMethod.values())
        ).collect(Collectors.toSet());
    }

    public static void process(PaymentMethod method) {
        if (!ACCEPTED_METHODS.contains(method)) {
            throw new IllegalArgumentException("Unsupported payment: " + method);
        }

        System.out.println("Processing with " + method.description());
    }

    public static String getReceiptNote(PaymentMethod method) {
        return switch(method) {
            case BasicMethodPayment.CREDIT_CARD -> "Charged to card";
            case CRYPTO -> "Blockchain confirmed";
            case CustomPaymentMethod.GIFT_CARD -> "Redeemed gift";
            default -> throw new IllegalStateException("Unexpected value: " + method);
        };
    }

    public static void main(String[] args) {
        PaymentProcessor.process(BasicMethodPayment.CREDIT_CARD);
        PaymentProcessor.process(CRYPTO);

        var receiptNote = PaymentProcessor.getReceiptNote(CRYPTO);
        System.out.println(receiptNote);
    }
}
