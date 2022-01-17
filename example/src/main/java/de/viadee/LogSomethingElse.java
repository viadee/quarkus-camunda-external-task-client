package de.viadee;

import de.viadee.camunda.extension.ExternalTaskSubscription;
import io.quarkus.arc.Unremovable;
import org.camunda.bpm.client.task.ExternalTask;
import org.camunda.bpm.client.task.ExternalTaskHandler;
import org.camunda.bpm.client.task.ExternalTaskService;

import javax.enterprise.context.ApplicationScoped;
import java.util.logging.Logger;

@ExternalTaskSubscription(topicName = "LogSomethingElse")
@ApplicationScoped
public class LogSomethingElse implements ExternalTaskHandler {

    private static final Logger LOG = Logger.getLogger(LogSomethingElse.class.getName());

    @Override
    public void execute(ExternalTask externalTask, ExternalTaskService externalTaskService) {
        LOG.info("Wir loggen was anderes");
        externalTaskService.complete(externalTask);
    }
}
