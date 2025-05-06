package com.example.spel;

import org.springframework.boot.CommandLineRunner;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.common.TemplateParserContext;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Component;

import java.util.GregorianCalendar;

@Component
public class SpelInAction implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        helloWorld();
        helloYou();
        addingNumbers();
        isGreaterThan();
    }

    private void helloYou() {
        String template = "#name";
        ExpressionParser parser = new SpelExpressionParser();
        EvaluationContext context = new StandardEvaluationContext();
        context.setVariable("name", "Richard");
        String message = parser.parseExpression(template).getValue(context, String.class);
        System.out.println(message); // Outputs: Hello, World!
    }

    private void helloWorld() {
        ExpressionParser parser = new SpelExpressionParser();
        Expression exp = parser.parseExpression("'Hello World'");
        String message = (String) exp.getValue();
        System.out.println(message);
    }

    private void addingNumbers() {
        String template = "2 + 3";
        ExpressionParser parser = new SpelExpressionParser();
        var message = (int) parser.parseExpression(template).getValue();
        System.out.println(message); // Outputs: Hello, World!
    }

    private void isGreaterThan() {
        String template = "#value1 > #value2";
        ExpressionParser parser = new SpelExpressionParser();
        EvaluationContext context = new StandardEvaluationContext();
        context.setVariable("value1", 5);
        context.setVariable("value2", 3);
        var message = (boolean) parser.parseExpression(template).getValue(context);
        System.out.println("Is 5 > 3: " + message ); // Outputs: Hello, World!
    }

}
