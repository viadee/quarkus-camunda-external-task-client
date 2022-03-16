package de.viadee;

import io.quarkus.logging.Log;
import org.camunda.bpm.engine.RuntimeService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/start-process")
public class StartExampleProcessService {

    private static final String PROCESS_NAME = "quarkus-camunda-external-task-example";


    @Inject
    public RuntimeService runtimeService;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String startProcessInstance() {
        String processInstanceId = runtimeService.startProcessInstanceByKey(PROCESS_NAME).getId();
        String message = "Process instance with id " + processInstanceId + " started!";
        Log.info(message);
        return message;
    }

}
