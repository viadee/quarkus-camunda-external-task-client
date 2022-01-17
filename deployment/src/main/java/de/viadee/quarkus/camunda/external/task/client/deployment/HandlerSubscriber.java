package de.viadee.quarkus.camunda.external.task.client.deployment;

import de.viadee.camunda.extension.ClientConfiguration;
import de.viadee.camunda.extension.ExternalTaskClientCreationRecorder;
import io.quarkus.arc.deployment.AdditionalBeanBuildItem;
import io.quarkus.arc.deployment.SyntheticBeanBuildItem;
import io.quarkus.arc.processor.DotNames;
import io.quarkus.deployment.annotations.BuildProducer;
import io.quarkus.deployment.annotations.BuildStep;
import io.quarkus.deployment.annotations.Record;
import io.quarkus.deployment.builditem.RunTimeConfigurationProxyBuildItem;
import org.camunda.bpm.client.ExternalTaskClient;

import javax.inject.Singleton;

import static io.quarkus.deployment.annotations.ExecutionTime.RUNTIME_INIT;

public class HandlerSubscriber {



    @Record(RUNTIME_INIT)
    @BuildStep
    public void externalTaskClientBuildItem(BuildProducer<SyntheticBeanBuildItem> producer,
                                            RunTimeConfigurationProxyBuildItem configurationProxyBuildItem,
                                            ExternalTaskClientCreationRecorder recorder,
                                            ClientConfiguration configuration) {

        var config = (ClientConfiguration) configurationProxyBuildItem.getProxyObjectFor(ClientConfiguration.class);
        producer.produce(
                SyntheticBeanBuildItem.configure(ExternalTaskClient.class)
                        .scope(Singleton.class)
                        .setRuntimeInit()
                        .unremovable()
                        .supplier(recorder.getSupplier(configuration))
                        .done()
        );
    }


}
