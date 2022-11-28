package br.tec.gvfsolucoes.ultimateracingcareer.exception;

public class ApplicationLoadingException extends RuntimeException {
    public ApplicationLoadingException() {
    }

    public ApplicationLoadingException(String message) {
        super(message);
    }

    public ApplicationLoadingException(String message, Throwable cause) {
        super(message, cause);
    }

    public ApplicationLoadingException(Throwable cause) {
        super(cause);
    }

    public ApplicationLoadingException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
