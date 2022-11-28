package br.tec.gvfsolucoes.ultimateracingcareer;

import br.tec.gvfsolucoes.ultimateracingcareer.conttroller.SplashController;
import br.tec.gvfsolucoes.ultimateracingcareer.exception.GlobalExceptionHandler;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Launcher extends Application {


    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Launcher.class.getResource(SplashController.FXML));
        Scene scene = new Scene(fxmlLoader.load(), SplashController.WIDTH, SplashController.HEIGTH);

        SplashController splashController = fxmlLoader.getController();
        splashController.setStage(stage);
        stage.setResizable(false);
        stage.setTitle("Ultimate Racing Career - Loading");
        stage.setScene(scene);
        stage.show();
        splashController.loadResources();
    }

    public static void main(String[] args) {
        Thread.setDefaultUncaughtExceptionHandler(new GlobalExceptionHandler());
        launch(args);
    }
}
