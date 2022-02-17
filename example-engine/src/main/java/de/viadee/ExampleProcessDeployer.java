package de.viadee;

import org.camunda.bpm.engine.RepositoryService;
import org.camunda.bpm.quarkus.engine.extension.event.CamundaEngineStartupEvent;

import javax.enterprise.event.Observes;
import javax.inject.Inject;

public class ExampleProcessDeployer {

    @Inject
    public RepositoryService repositoryService;

    // Method is called as soon as the Process Engine is running
    public void deployProcess(@Observes CamundaEngineStartupEvent startupEvent) {
        // Create a new deployment
        repositoryService.createDeployment()
                .addClasspathResource("process.bpmn") // Filename of the process model
                .enableDuplicateFiltering(true) // No redeployment when process model remains unchanged
                .deploy();
    }

}
