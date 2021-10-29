package de.viadee.camunda.extension;

import io.quarkus.runtime.annotations.Recorder;
import org.camunda.bpm.client.ExternalTaskClient;
import org.camunda.bpm.client.task.ExternalTaskHandler;

@Recorder
public class HandlerSubscriptionRecorder {

    public void registerHandler(ExternalTaskClient externalTaskClient, ExternalTaskHandler externalTaskHandler, String topic) {
        externalTaskClient.subscribe(topic).handler(externalTaskHandler).open();
    }

    // todo: open at runttime, subscription building at buildtime?


}
