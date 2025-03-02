package org.example.enums.calculator;

public enum CalculatorEnum {
    ADD {
        @Override
        int calculate(int x, int y) {
            return x + y;
        }
    },
    SUBSTRACT {
        @Override
        int calculate(int x, int y) {
            return x - y;
        }
    },
    MULTIPLAY {
        @Override
        int calculate(int x, int y) {
            return x * y;
        }
    };

    abstract int calculate(int x, int y);
}
