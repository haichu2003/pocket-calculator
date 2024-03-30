package main;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class Controller {
    private final VBox root;
    ArrayList<String> inputs;
    Double prevAns;
    private final GridPane numberPane;
    ArrayList<CalculatorButton> numbers;
    private final CalculatorButton point;
    private final CalculatorButton plus;
    private final CalculatorButton minus;
    private final CalculatorButton multiply;
    private final CalculatorButton divide;
    private final CalculatorButton ans;
    private final CalculatorButton equal;
    private final CalculatorButton del;
    private final CalculatorButton ac;
    private final Label inputScreen;
    private final Label ansScreen;

    public Controller() {
        this.prevAns = 0.0;
        this.root = new VBox(10);
        this.numberPane = new GridPane();
        this.numbers = new ArrayList<>();
        this.inputs = new ArrayList<>();
        for (int i = 0; i <= 9; ++i) {
            this.numbers.add(new CalculatorButton(Integer.toString(i), "", ""));
        }
        this.point = new CalculatorButton(".", "", "");
        this.plus = new CalculatorButton("+", "", "");
        this.minus = new CalculatorButton("-", "", "");
        this.multiply = new CalculatorButton("x", "", "");
        this.divide = new CalculatorButton("/", "", "");
        this.ans = new CalculatorButton("Ans", "", "");
        this.equal = new CalculatorButton("=", "", "");
        this.del = new CalculatorButton("Del", "", "");
        this.ac = new CalculatorButton("Ac", "", "");
        this.inputScreen = new Label();
        this.ansScreen = new Label();

        numberPane.setPrefWidth(40);
        for (int i = 0; i <= 9; ++i) {
            this.numbers.get(i).getMainButton().setMinWidth(numberPane.getPrefWidth());
        }
        plus.getMainButton().setMinWidth(numberPane.getPrefWidth());
        minus.getMainButton().setMinWidth(numberPane.getPrefWidth());
        multiply.getMainButton().setMinWidth(numberPane.getPrefWidth());
        divide.getMainButton().setMinWidth(numberPane.getPrefWidth());
        point.getMainButton().setMinWidth(numberPane.getPrefWidth());
        ans.getMainButton().setMinWidth(numberPane.getPrefWidth());
        equal.getMainButton().setMinWidth(numberPane.getPrefWidth());
        del.getMainButton().setMinWidth(numberPane.getPrefWidth());
        ac.getMainButton().setMinWidth(numberPane.getPrefWidth());
        inputScreen.setMinWidth(240);
        inputScreen.setMinHeight(70);
        inputScreen.setPadding(new Insets(10,10,10,10));
        inputScreen.setStyle("-fx-border-color: black; -fx-border-width: 1; -fx-border-style: solid; -fx-border-radius: 10;");
        inputScreen.setAlignment(Pos.BASELINE_LEFT);
        ansScreen.setMinWidth(240);
        ansScreen.setMinHeight(70);
        ansScreen.setPadding(new Insets(10, 10, 10, 10));
        ansScreen.setStyle("-fx-border-color: black; -fx-border-width: 1; -fx-border-style: solid; -fx-border-radius: 10;");
        ansScreen.setAlignment(Pos.BASELINE_RIGHT);

        numberPane.add(numbers.get(0).getMainButton(), 0, 3);
        numberPane.add(point.getMainButton(), 1, 3);
        numberPane.add(numbers.get(1).getMainButton(), 0, 2);
        numberPane.add(numbers.get(2).getMainButton(), 1, 2);
        numberPane.add(numbers.get(3).getMainButton(), 2, 2);
        numberPane.add(numbers.get(4).getMainButton(), 0, 1);
        numberPane.add(numbers.get(5).getMainButton(), 1, 1);
        numberPane.add(numbers.get(6).getMainButton(), 2, 1);
        numberPane.add(numbers.get(7).getMainButton(), 0, 0);
        numberPane.add(numbers.get(8).getMainButton(), 1, 0);
        numberPane.add(numbers.get(9).getMainButton(), 2, 0);
        numberPane.add(plus.getMainButton(), 3, 2);
        numberPane.add(minus.getMainButton(), 4, 2);
        numberPane.add(multiply.getMainButton(), 3, 1);
        numberPane.add(divide.getMainButton(), 4, 1);
        numberPane.add(ans.getMainButton(), 3, 3);
        numberPane.add(equal.getMainButton(), 4, 3);
        numberPane.add(del.getMainButton(), 3, 0);
        numberPane.add(ac.getMainButton(), 4, 0);

        // Add event handler for each button
        for (int i = 0; i < numbers.size(); ++i) {
            int finalI = i;
            numbers.get(i).getMainButton().setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    inputs.add(Integer.toString(finalI));
                    inputScreen.setText(String.join("", inputs));
                }
            });
        }
        plus.getMainButton().setOnAction(this::plusOnClick);
        minus.getMainButton().setOnAction(this::minusOnClick);
        multiply.getMainButton().setOnAction(this::multiplyOnClick);
        divide.getMainButton().setOnAction(this::divideOnClick);
        ans.getMainButton().setOnAction(this::ansOnClick);
        equal.getMainButton().setOnAction(this::equalOnClick);
        del.getMainButton().setOnAction(this::delOnClick);
        ac.getMainButton().setOnAction(this::acOnClick);
        point.getMainButton().setOnAction(this::pointOnClick);

        this.numberPane.setHgap(10);
        this.numberPane.setVgap(10);
        root.getChildren().addAll(inputScreen, ansScreen, numberPane);
        numberPane.setAlignment(Pos.CENTER);
        root.setAlignment(Pos.CENTER);
    }

    private void pointOnClick(ActionEvent actionEvent) {
        inputs.add(".");
        inputScreen.setText(String.join("", this.inputs));
    }

    private void acOnClick(ActionEvent actionEvent) {
        inputs.clear();
        inputScreen.setText(String.join("", this.inputs));
        ansScreen.setText("");
    }

    private void delOnClick(ActionEvent actionEvent) {
        inputs.remove(inputs.size() - 1);
        inputScreen.setText(String.join("", this.inputs));
    }

    private void plusOnClick(ActionEvent actionEvent) {
        inputs.add("+");
        inputScreen.setText(String.join("", this.inputs));
    }
    private void minusOnClick(ActionEvent actionEvent) {
        inputs.add("-");
        inputScreen.setText(String.join("", this.inputs));
    }
    private void multiplyOnClick(ActionEvent actionEvent) {
        inputs.add("*");
        inputScreen.setText(String.join("", this.inputs));
    }
    private void divideOnClick(ActionEvent actionEvent) {
        inputs.add("/");
        inputScreen.setText(String.join("", this.inputs));
    }
    private void ansOnClick(ActionEvent actionEvent) {
        inputs.add("Ans");
        inputScreen.setText(String.join("", this.inputs));
    }
    private void equalOnClick(ActionEvent actionEvent) {
        try {
            double temp = calculate(this.inputs);
            this.prevAns = temp;
            ansScreen.setText(Double.toString(temp));
            inputs.clear();
            inputScreen.setText(String.join("", this.inputs));
        } catch (ArithmeticException e) {
            ansScreen.setText(e.getMessage());
            inputs.clear();
            inputScreen.setText(String.join("", this.inputs));
        }
    }
    public double calculate(ArrayList<String> answers) throws ArithmeticException {
        if (answers.size() == 0.0) return 0.0;
        Stack<Double> values = new Stack<>();
        Stack<String> ops = new Stack<>();
        HashSet<String> n = new HashSet<>(List.of("0", "1", "2", "3", "4", "5", "6", "7", "8", "9"));
        int i = 0;
        while (i < answers.size()) {
            String a = answers.get(i);
            if (a.equals("(")) ops.add(a);
            else if (n.contains(a)) {
                StringBuilder temp = new StringBuilder();
                while (i < answers.size() && (n.contains(answers.get(i)) || answers.get(i).equals("."))) {
                    temp.append(answers.get(i));
                    i++;
                }
                i--;
                values.push(Double.parseDouble(temp.toString()));
            }
            else if (a.equals(")")) {
                while (!ops.peek().equals("(")) {
                    double val2 = values.pop();
                    double val1 = values.pop();
                    String op = ops.pop();
                    values.push(ops(val1, val2, op));
                }
                ops.pop();
            }
            else {
                while (!ops.isEmpty() && precedence(ops.peek()) >= precedence(a)) {
                    double val2 = values.pop();
                    double val1 = values.pop();
                    String op = ops.pop();
                    values.push(ops(val1, val2, op));
                }
                ops.push(a);
            }
            i ++;
        }
        while (!ops.isEmpty()) {
            double val2 = values.pop();
            double val1 = values.pop();
            String op = ops.pop();
            values.push(ops(val1, val2, op));
        }
        return values.pop();
    }
    public double ops(double a, double b, String op) throws ArithmeticException {
        if (op.equals("+")) return a + b;
        else if (op.equals("-")) return a - b;
        else if (op.equals("*")) return a * b;
        else if (b == 0) throw new ArithmeticException("Error: divided by 0");
        else return a / b;
    }
    public int precedence(String op) {
        if (op.equals("+") || op.equals("-")) return 1;
        else if (op.equals("*") || op.equals("/")) return 2;
        return 0;
    }
    public VBox getRoot() { return root; }
}
