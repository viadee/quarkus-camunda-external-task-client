package de.viadee.camunda.extension;

import org.camunda.bpm.client.ExternalTaskClient;
import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.OptionalInt;
import java.util.OptionalLong;
import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.assertNotNull;


class ExternalTaskClientCreationRecorderTest {

    ExternalTaskClientCreationRecorder underTest = new ExternalTaskClientCreationRecorder();

    @Test
    public void getSupplier() {
        ClientConfiguration clientConfiguration = new ClientConfiguration();
        clientConfiguration.baseUrl = "https://localhost:8080/rest-engine";
        clientConfiguration.workerID = Optional.of("foo");
        clientConfiguration.maxTasks = OptionalInt.of(10);
        clientConfiguration.usePriority = Optional.of(true);
        clientConfiguration.defaultSerializationFormat = Optional.of("bar");
        clientConfiguration.dateFormat = Optional.of("yyyy-MM-dd");
        clientConfiguration.asyncResponseTimeout = OptionalLong.of(1000);
        clientConfiguration.lockDuration = OptionalLong.of(1000);
        clientConfiguration.disableAutoFetching = Optional.of(true);
        clientConfiguration.disableBackoffStrategy = Optional.of(true);

        final Supplier<ExternalTaskClient> supplier = underTest.getSupplier(clientConfiguration);
        assertNotNull(supplier.get());
    }
}