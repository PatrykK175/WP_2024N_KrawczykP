package calculator.model.operation;

public class DivideOperation implements OperationStrategy {
    @Override
    public double doOperation(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Nie można dzielić przez zero!");
        }
        return a / b;
    }
}