package de.viadee;

import de.viadee.camunda.extension.ExternalTaskSubscription;
import io.quarkus.arc.Unremovable;
import org.camunda.bpm.client.task.ExternalTask;
import org.camunda.bpm.client.task.ExternalTaskHandler;
import org.camunda.bpm.client.task.ExternalTaskService;

import javax.enterprise.context.ApplicationScoped;
import java.util.logging.Logger;

@ApplicationScoped
@ExternalTaskSubscription(topicName = "LogOnConsole")
public class LogOnConsoleHandler implements ExternalTaskHandler {

    private static final Logger LOG = Logger.getLogger(LogOnConsoleHandler.class.getName());

    @Override
    public void execute(ExternalTask externalTask, ExternalTaskService externalTaskService) {
        LOG.info("This is an external task handler logging to the console");
        externalTaskService.complete(externalTask);
    }
}
