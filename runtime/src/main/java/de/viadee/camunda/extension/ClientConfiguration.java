package de.viadee.camunda.extension;

import io.quarkus.runtime.annotations.ConfigPhase;
import io.quarkus.runtime.annotations.ConfigRoot;
import org.eclipse.microprofile.config.inject.ConfigProperties;

@ConfigRoot(phase = ConfigPhase.RUN_TIME, prefix = "de.viadee.camunda")
public class ClientConfiguration {

    public String baseUrl;

    public String workerID;

    private String topic;

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public String getWorkerID() {
        return workerID;
    }

    public void setWorkerID(String workerID) {
        this.workerID = workerID;
    }

}
