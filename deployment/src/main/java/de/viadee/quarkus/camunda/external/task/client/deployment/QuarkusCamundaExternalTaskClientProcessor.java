package de.viadee.quarkus.camunda.external.task.client.deployment;

import io.quarkus.deployment.annotations.BuildStep;
import io.quarkus.deployment.builditem.FeatureBuildItem;

class QuarkusCamundaExternalTaskClientProcessor {

    private static final String FEATURE = "quarkus-camunda-external-task-client";

    @BuildStep
    FeatureBuildItem feature() {
        return new FeatureBuildItem(FEATURE);
    }
}
