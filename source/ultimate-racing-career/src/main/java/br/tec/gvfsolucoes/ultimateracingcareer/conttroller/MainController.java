package br.tec.gvfsolucoes.ultimateracingcareer.conttroller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class MainController {
    public static final String FXML = "fxml/main.fxml";
    public static final double WIDTH = 400.;
    public static final double HEIGTH = 400.;

    private Integer counterValue = 0;

    @FXML
    private Label counterNumber;

    @FXML
    protected void onIncrementButtonClick() {
        counterValue++;
        updateLabelNumber();
    }

    @FXML
    protected void onDecrementButtonClick() {
        counterValue--;
        updateLabelNumber();
    }

    private void updateLabelNumber() {
        counterNumber.setText(counterValue.toString());
        counterNumber.getStyleClass().removeAll("number-positive", "number-negative");
        if (counterValue > 0)
            counterNumber.getStyleClass().add("number-positive");
        else if (counterValue < 0)
            counterNumber.getStyleClass().add("number-negative");

    }
}
