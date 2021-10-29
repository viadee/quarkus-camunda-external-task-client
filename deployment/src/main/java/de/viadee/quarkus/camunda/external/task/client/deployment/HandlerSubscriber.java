package de.viadee.quarkus.camunda.external.task.client.deployment;

import de.viadee.camunda.extension.ClientConfiguration;
import de.viadee.camunda.extension.ExternalTaskClientCreationRecorder;
import de.viadee.camunda.extension.ExternalTaskSubscription;
import de.viadee.camunda.extension.HandlerSubscriptionRecorder;
import io.quarkus.arc.Arc;
import io.quarkus.arc.deployment.AdditionalBeanBuildItem;
import io.quarkus.arc.deployment.SyntheticBeanBuildItem;
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

import javax.inject.Singleton;

import java.util.function.Supplier;

import static io.quarkus.deployment.annotations.ExecutionTime.RUNTIME_INIT;

public class HandlerSubscriber {


    // wir brauchen einen/mehrere Handler in einem BuildItem
    // wir brauchen ein BuildItem, dass den ExternalTaskClient beinhaltet
    // todo: add dependency
    //  @Record(RUNTIME_INIT)
    // @BuildStep
    //public void subscribeHandler(HandlerSubscriptionRecorder handlerSubscriptionRecorder, ExternalTaskClientBuildItem externalTaskClientBuildItem) {
    //    handlerSubscriptionRecorder.registerHandler();
    // }


    @BuildStep
    public void subscribeHandler(HandlerSubscriptionRecorder recorder, CombinedIndexBuildItem combindeIndex) {
        var annotations = combindeIndex
                .getIndex()
                .getAnnotations(DotName.createSimple(ExternalTaskSubscription.class.getName()));
        for () {
            recorder.registerHandler();
        }
    }

    public HandlerSubscriber() {
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
