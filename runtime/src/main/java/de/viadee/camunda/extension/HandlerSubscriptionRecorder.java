package de.viadee.camunda.extension;

import io.quarkus.runtime.annotations.Recorder;
import org.camunda.bpm.client.ExternalTaskClient;
import org.camunda.bpm.client.task.ExternalTaskHandler;

import javax.inject.Inject;

@Recorder
public class HandlerSubscriptionRecorder {

    @Inject
    ExternalTaskClient externalTaskClient;

    public void registerHandler(ExternalTaskHandler externalTaskHandler, String topic) {
        externalTaskClient.subscribe(topic).handler(externalTaskHandler).open();
    }

    // todo: open at runttime, subscription building at buildtime?


}
