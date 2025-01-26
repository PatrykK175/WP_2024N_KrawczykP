package calculator;

import calculator.model.CalculatorModel;
import calculator.view.CalculatorView;
import calculator.controller.CalculatorController;

public class CalculatorApp {
    public static void main(String[] args) {
        CalculatorModel model = new CalculatorModel();
        CalculatorView view = new CalculatorView();
        CalculatorController controller = new CalculatorController(model, view);

        controller.run();
    }
}