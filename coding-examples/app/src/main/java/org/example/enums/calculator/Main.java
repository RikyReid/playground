package org.example.enums.calculator;

public class Main {
    public static void main(String[] args) {
        System.out.println(CalculatorEnum.ADD.calculate(10, 20));
        System.out.println(CalculatorEnum.SUBSTRACT.calculate(30, 5));
        System.out.println(CalculatorEnum.MULTIPLAY.calculate(5, 5));
    }
}
