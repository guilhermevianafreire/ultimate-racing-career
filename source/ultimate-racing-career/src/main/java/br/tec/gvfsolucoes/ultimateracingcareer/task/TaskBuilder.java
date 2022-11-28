package br.tec.gvfsolucoes.ultimateracingcareer.task;

import javafx.concurrent.Task;

import java.util.concurrent.Callable;

public class TaskBuilder {
    private TaskBuilder() {
    }

    public static <T> Task<T> create(Callable<T> callable) {
        return new Task<>() {
            @Override
            public T call() throws Exception {
                return callable.call();
            }
        };
    }
}
