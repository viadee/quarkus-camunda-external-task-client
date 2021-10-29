package de.viadee.camunda.extension;

import io.quarkus.runtime.annotations.Recorder;
import org.camunda.bpm.client.ExternalTaskClient;
import org.camunda.bpm.client.impl.ExternalTaskClientBuilderImpl;

import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import java.util.function.Supplier;

@Recorder
public class ExternalTaskClientCreationRecorder implements Supplier<ExternalTaskClient> {

    @Inject
    ClientConfiguration configuration;

    @Produces
    public ExternalTaskClient get() {
        var builder = new ExternalTaskClientBuilderImpl();
        return builder
                .baseUrl(configuration.getBaseUrl())
                .workerId(configuration.getWorkerID())
                .lockDuration(13)
                .maxTasks(10)
                .build();
    }


}
