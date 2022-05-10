package de.viadee.quarkus.camunda.external.task.client.deployment;

import de.viadee.camunda.extension.ClientConfiguration;
import de.viadee.camunda.extension.ExternalTaskClientCreationRecorder;
import de.viadee.camunda.extension.ExternalTaskSubscription;
import io.quarkus.arc.deployment.SyntheticBeanBuildItem;
import io.quarkus.arc.deployment.UnremovableBeanBuildItem;
import io.quarkus.deployment.annotations.BuildProducer;
import io.quarkus.deployment.annotations.BuildStep;
import io.quarkus.deployment.annotations.Record;
import io.quarkus.deployment.builditem.FeatureBuildItem;
import org.camunda.bpm.client.ExternalTaskClient;
import org.jboss.jandex.DotName;

import javax.inject.Singleton;

import static io.quarkus.deployment.annotations.ExecutionTime.RUNTIME_INIT;

class QuarkusCamundaExternalTaskClientProcessor {

    private static final String FEATURE = "quarkus-camunda-external-task-client";
    private static final DotName HANDLER_ANNOTATION_DOT_NAME = DotName.createSimple(ExternalTaskSubscription.class.getName());

    @BuildStep
    FeatureBuildItem feature() {
        return new FeatureBuildItem(FEATURE);
    }

    @Record(RUNTIME_INIT)
    @BuildStep
    public void externalTaskClientBuildItem(BuildProducer<SyntheticBeanBuildItem> producer,
                                            ExternalTaskClientCreationRecorder recorder,
                                            ClientConfiguration configuration) {

        producer.produce(
                SyntheticBeanBuildItem.configure(ExternalTaskClient.class)
                        .scope(Singleton.class)
                        .setRuntimeInit()
                        .unremovable()
                        .supplier(recorder.getSupplier(configuration))
                        .done()
        );
    }

    @BuildStep
    public UnremovableBeanBuildItem removalExclusion() {
        return new UnremovableBeanBuildItem(
                new UnremovableBeanBuildItem.BeanClassAnnotationExclusion(
                        HANDLER_ANNOTATION_DOT_NAME));
    }
}
