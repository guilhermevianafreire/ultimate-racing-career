package br.tec.gvfsolucoes.ultimateracingcareer.conttroller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HomeController {

    public static final String FXML = "fxml/home.fxml";

    @FXML
    private Label labelAcao;

    @FXML
    private void executar(ActionEvent event) {
        labelAcao.setText("Home");
    }

}
