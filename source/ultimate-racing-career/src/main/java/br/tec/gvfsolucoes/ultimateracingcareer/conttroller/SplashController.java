package br.tec.gvfsolucoes.ultimateracingcareer.conttroller;

import br.tec.gvfsolucoes.ultimateracingcareer.Launcher;
import br.tec.gvfsolucoes.ultimateracingcareer.db.LiquibaseHelper;
import br.tec.gvfsolucoes.ultimateracingcareer.exception.ApplicationLoadingException;
import br.tec.gvfsolucoes.ultimateracingcareer.task.TaskBuilder;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.stage.Stage;

import java.io.IOException;

public class SplashController {

    public static final String FXML = "fxml/splash.fxml";
    public static final double WIDTH = 400.0;
    public static final double HEIGTH = 400.0;

    private Stage stage;

    @FXML
    private ProgressBar loadingProcessBar;

    @FXML
    private Label percentage;

    @FXML
    private Label step;

    public void loadResources() {
        Task<Void> task = TaskBuilder.create(() -> {
            updateLoadingStep(.5, "Creating or updating the database");
            try (LiquibaseHelper liquibaseHelper = new LiquibaseHelper()) {
                liquibaseHelper
                        .validate()
                        .update();
            }
            updateLoadingStep(1., "Finished");
            Thread.sleep(1000);
            return null;
        });
        task.setOnSucceeded(event -> loadMainScene());
        Thread thread = new Thread(task);
        thread.setDaemon(true);
        thread.start();
    }

    public void loadMainScene() {
        try {
            Parent  parent = FXMLLoader.load(Launcher.class.getResource(MainController.FXML));
            Scene scene = new Scene(parent, MainController.WIDTH, MainController.HEIGTH);
            stage.setTitle("Ultimate Racing Career - Main");
            stage.setResizable(true);
            stage.setScene(scene);
        } catch (IOException e) {
            throw new ApplicationLoadingException(e);
        }
    }

    private void updateLoadingStep(double progress, String stepText) {
        Platform.runLater(() -> {
            loadingProcessBar.setProgress(progress);
            step.setText(stepText);
            percentage.setText(((int)(progress * 100.)) + " %");
        });
    }

    public SplashController setStage(Stage stage) {
        this.stage = stage;
        return this;
    }

}
