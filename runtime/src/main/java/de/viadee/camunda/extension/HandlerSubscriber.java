package de.viadee.camunda.extension;

import io.quarkus.arc.Arc;
import io.quarkus.runtime.StartupEvent;
import io.quarkus.runtime.annotations.Recorder;
import org.camunda.bpm.client.ExternalTaskClient;
import org.camunda.bpm.client.task.ExternalTaskHandler;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.spi.CDI;
import javax.inject.Inject;
import javax.inject.Singleton;
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
            var castAnnotation =  (ExternalTaskSubscription) annotation.get();

            this.registerHandler(instanceHandle.get(), castAnnotation.topicName());

        });

    }

    private void registerHandler(ExternalTaskHandler externalTaskHandler, String topic) {
        externalTaskClient.subscribe(topic)
                .handler(externalTaskHandler).open();
    }



}
