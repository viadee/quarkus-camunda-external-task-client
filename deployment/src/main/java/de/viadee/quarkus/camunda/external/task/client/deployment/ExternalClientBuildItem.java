package de.viadee.quarkus.camunda.external.task.client.deployment;

import io.quarkus.builder.item.SimpleBuildItem;
import io.quarkus.runtime.RuntimeValue;
import org.camunda.bpm.client.ExternalTaskClient;

public final class ExternalClientBuildItem extends SimpleBuildItem {
    public RuntimeValue<ExternalTaskClient> client;

    public ExternalClientBuildItem(RuntimeValue<ExternalTaskClient> runtimeClient) {
        this.client = runtimeClient;
    }
}
