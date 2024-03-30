package main;

import javafx.scene.control.Button;
public class CalculatorButton {
    private final Button mainButton;
    private final Button shiftButton;
    private final Button alphaButton;
    public CalculatorButton(String mainSymbol, String shiftSymbol, String alphaSymbol) {
        this.mainButton = new Button(mainSymbol);
        this.shiftButton = new Button(shiftSymbol);
        this.alphaButton = new Button(alphaSymbol);
    }
    public Button getMainButton() {
        return mainButton;
    }
    public Button getShiftButton() {
        return shiftButton;
    }
    public Button getAlphaButton() {
        return alphaButton;
    }
}
