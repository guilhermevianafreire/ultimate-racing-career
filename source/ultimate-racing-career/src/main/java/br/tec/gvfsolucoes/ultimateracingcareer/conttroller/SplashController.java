package br.tec.gvfsolucoes.ultimateracingcareer.conttroller;

import br.tec.gvfsolucoes.ultimateracingcareer.Launcher;
import br.tec.gvfsolucoes.ultimateracingcareer.db.LiquibaseHelper;
import br.tec.gvfsolucoes.ultimateracingcareer.exception.ApplicationLoadingException;
import br.tec.gvfsolucoes.ultimateracingcareer.task.LoadingTask;
import br.tec.gvfsolucoes.ultimateracingcareer.task.TaskBuilder;
import br.tec.gvfsolucoes.ultimateracingcareer.task.ThreadPool;
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
    private Label step;

    public void loadResources() {
        LoadingTask task = new LoadingTask();
        loadingProcessBar.progressProperty().bind(task.progressProperty());
        step.textProperty().bind(task.messageProperty());
        task.setOnSucceeded(event -> loadMainScene());
        ThreadPool.getInstance().getExecutor().execute(task);
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

    public SplashController setStage(Stage stage) {
        this.stage = stage;
        return this;
    }

}
