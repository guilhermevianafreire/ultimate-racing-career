package br.tec.gvfsolucoes.ultimateracingcareer.conttroller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class DriverController {

    public static final String FXML = "fxml/driver.fxml";

    @FXML
    private Label labelAcao;

    @FXML
    private void executar(ActionEvent event) {
        labelAcao.setText("Driver");
    }

}
