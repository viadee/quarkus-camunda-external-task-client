package de.viadee;

import io.quarkus.test.junit.QuarkusTest;
import org.camunda.bpm.client.ExternalTaskClient;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

@QuarkusTest
public class ExampleResourceTest {

    @Inject
    ExternalTaskClient client;

    @Inject
    LogOnConsoleHandler handler;

    @Test
    public void testHelloEndpoint() {
        int i = 5;

    }

}