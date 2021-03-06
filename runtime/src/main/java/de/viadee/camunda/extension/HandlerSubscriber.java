package de.viadee.camunda.extension;

import io.quarkus.arc.Arc;
import io.quarkus.runtime.StartupEvent;
import org.camunda.bpm.client.ExternalTaskClient;
import org.camunda.bpm.client.task.ExternalTaskHandler;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import java.util.Arrays;

@ApplicationScoped
public class HandlerSubscriber {

    @Inject
    ExternalTaskClient externalTaskClient;

    public void registerHandlers(@Observes StartupEvent ev) {
        Arc.container().select(ExternalTaskHandler.class).handles().forEach(instanceHandle -> {
            var annotation = Arrays.stream(instanceHandle.getBean().getBeanClass().getAnnotations())
                    .filter(a -> a instanceof ExternalTaskSubscription)
                    .findFirst();
            if (annotation.isEmpty()) {
                return;
            }
            var castAnnotation = (ExternalTaskSubscription) annotation.get();

            this.registerHandler(instanceHandle.get(), castAnnotation);

        });

    }

    private void registerHandler(ExternalTaskHandler externalTaskHandler, ExternalTaskSubscription subscription) {
        externalTaskClient.subscribe(subscription.topicName())
                .variables(subscription.variableNames())
                .localVariables(subscription.localVariables())
                .businessKey(subscription.businessKey())
                .processDefinitionId(subscription.processDefinitionId())
                .processDefinitionIdIn(subscription.processDefinitionIdIn())
                .processDefinitionKey(subscription.processDefinitionKey())
                .processDefinitionKeyIn(subscription.processDefinitionKeyIn())
                .processDefinitionVersionTag(subscription.processDefinitionVersionTag())
                .tenantIdIn(subscription.tenantIdIn())
                .includeExtensionProperties(subscription.includeExtensionProperties())
                .handler(externalTaskHandler).open();
    }


}
