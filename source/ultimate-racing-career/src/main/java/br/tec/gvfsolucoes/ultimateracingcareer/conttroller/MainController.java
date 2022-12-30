package br.tec.gvfsolucoes.ultimateracingcareer.conttroller;

import br.tec.gvfsolucoes.ultimateracingcareer.Launcher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {
    public static final String FXML = "fxml/main.fxml";
    public static final double WIDTH = 854.;
    public static final double HEIGTH = 480.;

    private Stage stage;

    @FXML
    private BorderPane mainPane;

    public void initialize() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Launcher.class.getResource(HomeController.FXML));
            mainPane.setCenter(fxmlLoader.load());
            mainPane.requestFocus();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    private void openConfigurationDriver(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Launcher.class.getResource(DriverController.FXML));
            mainPane.setCenter(fxmlLoader.load());
            mainPane.requestFocus();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    private void openApplicationHome(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Launcher.class.getResource(HomeController.FXML));
            mainPane.setCenter(fxmlLoader.load());
            mainPane.requestFocus();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public MainController setMainPane(BorderPane borderPane) {
        return this;
    }

    public MainController setStage(Stage stage) {
        this.stage = stage;
        return this;
    }
}
