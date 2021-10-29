package de.viadee.quarkus.camunda.external.task.client.deployment;

import de.viadee.camunda.extension.ClientConfiguration;
import de.viadee.camunda.extension.ExternalTaskClientCreationRecorder;
import de.viadee.camunda.extension.ExternalTaskSubscription;
import de.viadee.camunda.extension.HandlerSubscriptionRecorder;
import io.quarkus.arc.Arc;
import io.quarkus.arc.deployment.AdditionalBeanBuildItem;
import io.quarkus.arc.deployment.BeanDiscoveryFinishedBuildItem;
import io.quarkus.arc.deployment.SyntheticBeanBuildItem;
import io.quarkus.arc.processor.BeanInfo;
import io.quarkus.builder.item.SimpleBuildItem;
import io.quarkus.deployment.annotations.BuildProducer;
import io.quarkus.deployment.annotations.BuildStep;
import io.quarkus.deployment.annotations.ExecutionTime;
import io.quarkus.deployment.annotations.Record;
import io.quarkus.deployment.builditem.CombinedIndexBuildItem;
import io.quarkus.deployment.builditem.ConfigurationBuildItem;
import io.quarkus.runtime.annotations.Recorder;
import org.camunda.bpm.client.ExternalTaskClient;
import org.camunda.bpm.client.impl.ExternalTaskClientBuilderImpl;
import org.camunda.bpm.client.task.ExternalTaskHandler;
import org.jboss.jandex.DotName;

import javax.enterprise.inject.spi.CDI;
import javax.inject.Singleton;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

import static io.quarkus.deployment.annotations.ExecutionTime.RUNTIME_INIT;
import static java.util.stream.Collectors.toList;

public class HandlerSubscriber {

    @BuildStep
    public void subscribeHandler(HandlerSubscriptionRecorder recorder,
                                 BeanDiscoveryFinishedBuildItem beanDiscovery) {

        CDI.current().select(ExternalTaskHandler.class).stream().forEach(
                handler -> {
                    var annotation = Arrays.stream(handler.getClass().getAnnotations())
                            .filter(a -> a instanceof ExternalTaskSubscription)
                            .findFirst();
                    if (annotation.isEmpty()) {
                        return;
                    }
                    var castAnnotation =  (ExternalTaskSubscription) annotation.get();
                    recorder.registerHandler(handler,castAnnotation.topicName());
                }
        );
    }


    @Record(RUNTIME_INIT)
    @BuildStep
    public void externalTaskClientBuildItem(BuildProducer<SyntheticBeanBuildItem> producer, ExternalTaskClientCreationRecorder recorder) {
        producer.produce(
                SyntheticBeanBuildItem.configure(ExternalTaskClient.class)
                        .scope(Singleton.class)
                        .setRuntimeInit()
                        .unremovable()
                        .supplier(recorder)
                        .done()
        );
    }


}
