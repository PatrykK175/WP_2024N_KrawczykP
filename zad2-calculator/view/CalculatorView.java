package calculator.view;

import java.util.Scanner;

public class CalculatorView {
    private final Scanner scanner;

    public CalculatorView() {
        this.scanner = new Scanner(System.in);
    }

    public void showWelcomeMessage() {
        System.out.println("Prosty kalkulator w architekturze MVC + wzorzec Strategia.");
        System.out.println("Dostępne operatory: +, -, *, /");
    }

    public double getNumber(String message) {
        System.out.print(message);
        return scanner.nextDouble();
    }

    public char getOperator(String message) {
        System.out.print(message);
        return scanner.next().charAt(0);
    }

    public void showResult(double result) {
        System.out.println("Wynik: " + result);
    }

    public void showError(String errorMessage) {
        System.out.println("Błąd: " + errorMessage);
    }
}