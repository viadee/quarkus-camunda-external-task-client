package de.viadee.camunda.extension;

import io.quarkus.runtime.annotations.Recorder;
import org.camunda.bpm.client.ExternalTaskClient;
import org.camunda.bpm.client.task.ExternalTaskHandler;

import javax.enterprise.inject.spi.CDI;
import javax.inject.Inject;
import java.util.Arrays;

@Recorder
public class HandlerSubscriptionRecorder {

    @Inject
    ExternalTaskClient externalTaskClient;

    private void registerHandler(ExternalTaskHandler externalTaskHandler, String topic) {
        externalTaskClient.subscribe(topic).handler(externalTaskHandler).open();
    }


    public void registerHandlers() {
        CDI.current().select(ExternalTaskHandler.class).stream().forEach(
                handler -> {
                    var annotation = Arrays.stream(handler.getClass().getAnnotations())
                            .filter(a -> a instanceof ExternalTaskSubscription)
                            .findFirst();
                    if (annotation.isEmpty()) {
                        return;
                    }
                    var castAnnotation =  (ExternalTaskSubscription) annotation.get();

                    this.registerHandler(handler,castAnnotation.topicName());
                }
        );
    }

    // todo: open at runttime, subscription building at buildtime?


}
