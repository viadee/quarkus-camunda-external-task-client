package de.viadee.camunda.api;

import de.viadee.camunda.api.mapper.LockedExternalTaskMapper;
import de.viadee.camunda.api.requests.CompleteRequest;
import de.viadee.camunda.api.requests.FetchAndLockRequest;
import de.viadee.camunda.api.responses.LockedExternalTaskResponse;
import io.quarkus.logging.Log;
import org.camunda.bpm.engine.ExternalTaskService;
import org.camunda.bpm.engine.externaltask.ExternalTaskQueryBuilder;
import org.camunda.bpm.engine.externaltask.LockedExternalTask;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Path("/engine-rest/external-task")
public class ExternalTaskResource {

    @Inject
    ExternalTaskService externalTaskService;

    @Inject
    LockedExternalTaskMapper lockedExternalTaskMapper;

    @POST
    @Path("/fetchAndLock")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<LockedExternalTaskResponse> fetchAndLock(FetchAndLockRequest request) {
        Log.info("Called `fetchAndLock` with payload: " + request);

        final ExternalTaskQueryBuilder externalTaskQueryBuilder =
                externalTaskService.fetchAndLock(request.getMaxTasks(), request.getWorkerId());

        request.getTopics().forEach(c -> externalTaskQueryBuilder.topic(c.getTopicName(), c.getLockDuration()));
        List<LockedExternalTask> externalTasks = externalTaskQueryBuilder.execute();

        List<LockedExternalTaskResponse> responses = externalTasks
                .stream()
                .map(e -> lockedExternalTaskMapper.map(e))
                .collect(Collectors.toList());


        Log.info("Responding `fetchAndLock` with payload: " + responses);

        return responses;
    }

    @POST
    @Path("/{id}/complete")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response complete(@PathParam("id") String id, CompleteRequest request) {
        Log.info("Called `complete` for id " + id + " with payload: " + request);

        Map<String, Object> variables = request.getVariables().entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        externalTaskService.complete(id, request.getWorkerId(), variables);
        return Response.ok().build();
    }

    @POST
    @Path("/external-task/{id}/unlock")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    public Response unlock(@PathParam("id") String id) {
        Log.info("Called `unlock` for id: " + id);
        externalTaskService.unlock(id);
        return Response.status(204).build();
    }
}
