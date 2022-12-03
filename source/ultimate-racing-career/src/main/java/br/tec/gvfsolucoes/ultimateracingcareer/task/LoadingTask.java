package br.tec.gvfsolucoes.ultimateracingcareer.task;

import br.tec.gvfsolucoes.ultimateracingcareer.db.LiquibaseHelper;
import javafx.concurrent.Task;

public class LoadingTask extends Task<Throwable> {
    /**
     * Invoked when the Task is executed, the call method must be overridden and
     * implemented by subclasses. The call method actually performs the
     * background thread logic. Only the updateProgress, updateMessage, updateValue and
     * updateTitle methods of Task may be called from code within this method.
     * Any other interaction with the Task from the background thread will result
     * in runtime exceptions.
     *
     * @return The result of the background work, if any.
     * @throws Exception an unhandled exception which occurred during the
     *                   background operation
     */
    @Override
    protected Throwable call() throws Exception {
        updateProgress(.5, 1.);
        updateMessage("Creating or updating the database");
        try (LiquibaseHelper liquibaseHelper = new LiquibaseHelper()) {
            liquibaseHelper
                    .validate()
                    .update();
        } catch (Throwable t) {
            return t;
        }
        updateProgress(1., 1.);
        updateMessage("Finished");
        Thread.sleep(500);
        return null;
    }
}
