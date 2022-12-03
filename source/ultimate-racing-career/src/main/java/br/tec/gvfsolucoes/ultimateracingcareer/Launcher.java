package br.tec.gvfsolucoes.ultimateracingcareer;

import br.tec.gvfsolucoes.ultimateracingcareer.conttroller.SplashController;
import br.tec.gvfsolucoes.ultimateracingcareer.db.DatabaseHelper;
import br.tec.gvfsolucoes.ultimateracingcareer.exception.GlobalExceptionHandler;
import br.tec.gvfsolucoes.ultimateracingcareer.task.ThreadPool;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.util.Objects;

public class Launcher extends Application {

    private static final Logger LOGGER = LoggerFactory.getLogger(Launcher.class);

    private static RandomAccessFile randomFile;
    private static FileChannel channel;

    /**
     * The main entry point for all JavaFX applications.
     * The start method is called after the init method has returned,
     * and after the system is ready for the application to begin running.
     *
     * <p>
     * NOTE: This method is called on the JavaFX Application Thread.
     * </p>
     *
     * @param stage the primary stage for this application, onto which
     * the application scene can be set.
     * Applications may create other stages, if needed, but they will not be
     * primary stages.
     * @throws java.lang.Exception if something goes wrong
     */
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
        if (Objects.nonNull(channel) && channel.isOpen())
            channel.close();
        if (Objects.nonNull(randomFile))
            randomFile.close();
        super.stop();
    }

    public static void main(String[] args) {
        checkSingleInstance();
        Thread.setDefaultUncaughtExceptionHandler(new GlobalExceptionHandler());
        launch(args);
    }

    /**
     * Check if the application is already running.<br>
     * If it is running, the second instance is not going to start.
     */
    private static void checkSingleInstance() {
        try {
            randomFile = new RandomAccessFile("lock","rw");
            channel = randomFile.getChannel();
            if(channel.tryLock() == null) {
                LOGGER.error("The application is already running");
                System.exit(0);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
