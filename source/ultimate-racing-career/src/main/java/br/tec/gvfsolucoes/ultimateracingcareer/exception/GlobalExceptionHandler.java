package br.tec.gvfsolucoes.ultimateracingcareer.exception;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GlobalExceptionHandler implements Thread.UncaughtExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        LOGGER.error(e.getMessage(), e);
        if (e instanceof ApplicationLoadingException applicationLoadingException)
            new Alert(Alert.AlertType.ERROR, applicationLoadingException.toString(), ButtonType.OK);
        else
            new Alert(Alert.AlertType.ERROR, "A unexpected error ocurred. Check the error logs for more information", ButtonType.OK);
        System.exit(-1);
    }
}
