package calculator.model.operation;

public class SubtractOperation implements OperationStrategy {
    @Override
    public double doOperation(double a, double b) {
        return a - b;
    }
}