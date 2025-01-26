package calculator.model.operation;

public class MultiplyOperation implements OperationStrategy {
    @Override
    public double doOperation(double a, double b) {
        return a * b;
    }
}