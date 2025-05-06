package com.example.spel;

import org.springframework.boot.CommandLineRunner;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SpelObjectInteraction implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        overSixty();
    }

    private void overSixty() {
        String template = "age > 60";
        ExpressionParser parser = new SpelExpressionParser();

        for (Person person : persons()) {
            StandardEvaluationContext context = new StandardEvaluationContext(person);

            var overSixty = parser.parseExpression(template).getValue(context, Boolean.class);
            if (overSixty) {
                System.out.println(person.firstname + " is over sixty");
            }
        }

    }

    private List<Person> persons() {
        return List.of(new Person("James", "Kirk", 50),
                new Person("Leonard", "Mccoy", 65));
    }
    record Person(String firstname, String surname, int age) {}
}
