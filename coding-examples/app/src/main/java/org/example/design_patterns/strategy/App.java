package org.example.design_patterns.strategy;

public class App {
    public static void main(String[] args) {
        var sterlingConverter = new SterlingConverter(new USDollar());
        var usConversion = sterlingConverter.convert(10.00);
       System.out.println("US dollar conversion: " + usConversion);

        var sterlingConverter2 = new SterlingConverter(new Euro());
        var euroConversion = sterlingConverter2.convert(10.00);
        System.out.println("Euro conversion: " + euroConversion);
    }
}
