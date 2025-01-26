package calculator.model;

import calculator.model.operation.OperationStrategy;

public class CalculatorModel {
    private double a;
    private double b;
    private double result;
    private OperationStrategy strategy;

    public CalculatorModel() {
    }

    public void setA(double a) {
        this.a = a;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getResult() {
        return result;
    }

    public void setOperationStrategy(OperationStrategy strategy) {
        this.strategy = strategy;
    }

    public void compute() {
        if (strategy == null) {
            throw new IllegalStateException("Strategia (operacja) nie została ustawiona!");
        }
        result = strategy.doOperation(a, b);
    }
}