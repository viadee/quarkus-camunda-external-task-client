package de.viadee.quarkus.camunda.external.task.client.deployment;

import de.viadee.camunda.extension.ClientConfiguration;
import de.viadee.camunda.extension.ExternalTaskClientCreationRecorder;
import de.viadee.camunda.extension.ExternalTaskSubscription;
import de.viadee.camunda.extension.HandlerSubscriptionRecorder;
import io.quarkus.arc.Arc;
import io.quarkus.arc.deployment.BeanDiscoveryFinishedBuildItem;
import io.quarkus.arc.deployment.SyntheticBeanBuildItem;
import io.quarkus.deployment.annotations.BuildProducer;
import io.quarkus.deployment.annotations.BuildStep;
import io.quarkus.deployment.annotations.Record;
import io.quarkus.deployment.builditem.RunTimeConfigurationProxyBuildItem;
import org.camunda.bpm.client.ExternalTaskClient;
import org.camunda.bpm.client.task.ExternalTaskHandler;

import javax.enterprise.inject.spi.CDI;
import javax.inject.Singleton;
import java.util.Arrays;

import static io.quarkus.deployment.annotations.ExecutionTime.RUNTIME_INIT;

public class HandlerSubscriber {

    @BuildStep
    @Record(RUNTIME_INIT)
    public void subscribeHandler(HandlerSubscriptionRecorder recorder,
                                 BeanDiscoveryFinishedBuildItem beanDiscovery
                                 ) {
        recorder.registerHandlers();
    }


    @Record(RUNTIME_INIT)
    @BuildStep
    public void externalTaskClientBuildItem(BuildProducer<SyntheticBeanBuildItem> producer,
                                            RunTimeConfigurationProxyBuildItem configurationProxyBuildItem,
                                            ExternalTaskClientCreationRecorder recorder) {

        var config = (ClientConfiguration) configurationProxyBuildItem.getProxyObjectFor(ClientConfiguration.class);
        producer.produce(
                SyntheticBeanBuildItem.configure(ExternalTaskClient.class)
                        .scope(Singleton.class)
                        .setRuntimeInit()
                        .unremovable()
                        .supplier(recorder.getSupplier(config))
                        .done()
        );
    }


}
