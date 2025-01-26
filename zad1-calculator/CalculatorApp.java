import java.util.Scanner;

interface OperationStrategy {
    double doOperation(double a, double b);
}

class AddOperation implements OperationStrategy {
    @Override
    public double doOperation(double a, double b) {
        return a + b;
    }
}

class SubtractOperation implements OperationStrategy {
    @Override
    public double doOperation(double a, double b) {
        return a - b;
    }
}

class MultiplyOperation implements OperationStrategy {
    @Override
    public double doOperation(double a, double b) {
        return a * b;
    }
}

class DivideOperation implements OperationStrategy {
    @Override
    public double doOperation(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Nie można dzielić przez zero!");
        }
        return a / b;
    }
}

class CalculatorContext {
    private OperationStrategy strategy;

    public void setStrategy(OperationStrategy strategy) {
        this.strategy = strategy;
    }

    public double executeStrategy(double a, double b) {
        if (strategy == null) {
            throw new IllegalStateException("Strategia nie została ustawiona!");
        }
        return strategy.doOperation(a, b);
    }
}

public class CalculatorApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CalculatorContext calculator = new CalculatorContext();

        System.out.println("Prosty kalkulator (Strategia). Dostępne operacje: +, -, *, /");
        System.out.print("Podaj pierwszą liczbę: ");
        double a = scanner.nextDouble();

        System.out.print("Podaj operator (+, -, *, /): ");
        char operator = scanner.next().charAt(0);

        System.out.print("Podaj drugą liczbę: ");
        double b = scanner.nextDouble();

        switch (operator) {
            case '+':
                calculator.setStrategy(new AddOperation());
                break;
            case '-':
                calculator.setStrategy(new SubtractOperation());
                break;
            case '*':
                calculator.setStrategy(new MultiplyOperation());
                break;
            case '/':
                calculator.setStrategy(new DivideOperation());
                break;
            default:
                System.out.println("Nieprawidłowy operator!");
                return;
        }

        try {
            double result = calculator.executeStrategy(a, b);
            System.out.println("Wynik: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Błąd: " + e.getMessage());
        }
    }
}
