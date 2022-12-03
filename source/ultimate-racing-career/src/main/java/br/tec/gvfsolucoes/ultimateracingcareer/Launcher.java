package br.tec.gvfsolucoes.ultimateracingcareer;

import br.tec.gvfsolucoes.ultimateracingcareer.conttroller.SplashController;
import br.tec.gvfsolucoes.ultimateracingcareer.db.DatabaseHelper;
import br.tec.gvfsolucoes.ultimateracingcareer.exception.GlobalExceptionHandler;
import br.tec.gvfsolucoes.ultimateracingcareer.task.ThreadPool;
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

    /**
     * This method is called when the application should stop, and provides a
     * convenient place to prepare for application exit and destroy resources.
     *
     * <p>
     * The implementation of this method provided by the Application class does nothing.
     * </p>
     *
     * <p>
     * NOTE: This method is called on the JavaFX Application Thread.
     * </p>
     *
     * @throws Exception if something goes wrong
     */
    @Override
    public void stop() throws Exception {
        ThreadPool.getInstance().close();
        super.stop();
    }

    public static void main(String[] args) {
        Thread.setDefaultUncaughtExceptionHandler(new GlobalExceptionHandler());
        launch(args);
    }
}
