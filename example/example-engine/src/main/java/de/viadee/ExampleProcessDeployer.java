package de.viadee;

import org.camunda.bpm.engine.RepositoryService;
import org.camunda.bpm.quarkus.engine.extension.event.CamundaEngineStartupEvent;

import javax.enterprise.event.Observes;
import javax.inject.Inject;

public class ExampleProcessDeployer {

    @Inject
    public RepositoryService repositoryService;

    public void deployProcess(@Observes CamundaEngineStartupEvent startupEvent) {
        repositoryService.createDeployment()
                .addClasspathResource("process.bpmn")
                .enableDuplicateFiltering(true)
                .deploy();
    }

}
