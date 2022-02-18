package de.viadee.camunda.extension;

import io.quarkus.runtime.annotations.Recorder;
import org.camunda.bpm.client.ExternalTaskClient;
import org.camunda.bpm.client.impl.ExternalTaskClientBuilderImpl;

import java.util.function.Supplier;

@Recorder
public class ExternalTaskClientCreationRecorder {


    public Supplier<ExternalTaskClient> getSupplier(ClientConfiguration config) {
        return () -> {
            var builder = new ExternalTaskClientBuilderImpl();
            builder.baseUrl(config.baseUrl);
            config.workerID.ifPresent(builder::workerId);
            config.maxTasks.ifPresent(builder::maxTasks);
            config.usePriority.ifPresent(builder::usePriority);
            config.defaultSerializationFormat.ifPresent(builder::defaultSerializationFormat);
            config.dateFormat.ifPresent(builder::dateFormat);
            config.asyncResponseTimeout.ifPresent(builder::asyncResponseTimeout);
            config.lockDuration.ifPresent(builder::lockDuration);
            config.disableAutoFetching.ifPresent(disable -> {
                if (disable) {
                    builder.disableAutoFetching();
                }
            });
            config.disableBackoffStrategy.ifPresent(disable -> {
                if (disable) {
                    builder.disableBackoffStrategy();
                }
            });
            return builder.build();
        };

    }


}
