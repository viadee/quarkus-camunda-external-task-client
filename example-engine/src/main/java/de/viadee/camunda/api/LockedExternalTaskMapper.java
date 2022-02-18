package de.viadee.camunda.api;

import de.viadee.camunda.api.responses.LockedExternalTaskResponse;
import org.camunda.bpm.engine.externaltask.LockedExternalTask;

import javax.enterprise.context.ApplicationScoped;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;

@ApplicationScoped
public class LockedExternalTaskMapper {


    public LockedExternalTaskResponse map(LockedExternalTask lockedExternalTask) {
        LockedExternalTaskResponse fetchAndLockResponse = new LockedExternalTaskResponse();
        fetchAndLockResponse.setId(lockedExternalTask.getId());
        fetchAndLockResponse.setTopicName(lockedExternalTask.getTopicName());
        fetchAndLockResponse.setWorkerId(lockedExternalTask.getWorkerId());
        fetchAndLockResponse.setLockExpirationTime(
                lockedExternalTask.getLockExpirationTime()
                        .toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime().truncatedTo(ChronoUnit.SECONDS));
        fetchAndLockResponse.setProcessInstanceId(lockedExternalTask.getProcessInstanceId());
        fetchAndLockResponse.setExecutionId(lockedExternalTask.getExecutionId());
        fetchAndLockResponse.setActivityId(lockedExternalTask.getActivityId());
        fetchAndLockResponse.setActivityInstanceId(lockedExternalTask.getActivityInstanceId());
        fetchAndLockResponse.setProcessDefinitionId(lockedExternalTask.getProcessDefinitionId());
        fetchAndLockResponse.setProcessDefinitionKey(lockedExternalTask.getProcessDefinitionKey());
        fetchAndLockResponse.setProcessDefinitionVersionTag(lockedExternalTask.getProcessDefinitionVersionTag());
        fetchAndLockResponse.setRetries(lockedExternalTask.getRetries());
        fetchAndLockResponse.setErrorMessage(lockedExternalTask.getErrorMessage());
        fetchAndLockResponse.setErrorDetails(lockedExternalTask.getErrorDetails());
        // TODO: Variablen mappen
        fetchAndLockResponse.setVariableMap(null);
        fetchAndLockResponse.setTenantId(lockedExternalTask.getTenantId());
        fetchAndLockResponse.setPriority(lockedExternalTask.getPriority());
        fetchAndLockResponse.setBusinessKey(lockedExternalTask.getBusinessKey());
        fetchAndLockResponse.setExtensionProperties(lockedExternalTask.getExtensionProperties());
        return fetchAndLockResponse;
    }


}
