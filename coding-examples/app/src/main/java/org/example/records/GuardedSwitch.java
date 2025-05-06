package org.example.records;

import java.util.List;

public class GuardedSwitch {
    public static void main(String[] args) {
        var user1 = new Person("John", "Doe", 45, Gender.MALE);
        var user2 = new Person("Jane", "Doe", 35, Gender.FEMALE);

        var users = List.of(user1, user2);

        switch (user1) {
            case Person(
                    String firstname, String surname, int age, Gender gender
            ) when gender == Gender.MALE && age > 30 -> System.out.println(firstname + " is a male over 30");
            case Person(
                    String firstname, String surname, int age, Gender gender
            ) when gender == Gender.FEMALE && age > 30 -> System.out.println(firstname + " is a female over 30");
            default -> throw new IllegalStateException("Unexpected value: " + user1);
        }
    }

    record Person(String firstname, String surname, int age, Gender gender) {
    }

    enum Gender {MALE, FEMALE}
}
