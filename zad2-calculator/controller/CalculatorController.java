package calculator.controller;

import calculator.model.CalculatorModel;
import calculator.model.operation.*;
import calculator.view.CalculatorView;

public class CalculatorController {
    private final CalculatorModel model;
    private final CalculatorView view;

    public CalculatorController(CalculatorModel model, CalculatorView view) {
        this.model = model;
        this.view = view;
    }

    public void run() {
        view.showWelcomeMessage();

        double a = view.getNumber("Podaj pierwszą liczbę: ");
        char operator = view.getOperator("Podaj operator (+, -, *, /): ");
        double b = view.getNumber("Podaj drugą liczbę: ");

        model.setA(a);
        model.setB(b);

        switch (operator) {
            case '+':
                model.setOperationStrategy(new AddOperation());
                break;
            case '-':
                model.setOperationStrategy(new SubtractOperation());
                break;
            case '*':
                model.setOperationStrategy(new MultiplyOperation());
                break;
            case '/':
                model.setOperationStrategy(new DivideOperation());
                break;
            default:
                view.showError("Nieprawidłowy operator!");
                return;
        }

        try {
            model.compute();
            view.showResult(model.getResult());
        } catch (ArithmeticException | IllegalStateException e) {
            view.showError(e.getMessage());
        }
    }
}