package de.viadee.camunda.extension;

import org.eclipse.microprofile.config.inject.ConfigProperties;

@ConfigProperties(prefix = "de.viadee.camunda") // todo: config root?
public class ClientConfiguration {

    private String baseUrl;

    private String workerID;

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
