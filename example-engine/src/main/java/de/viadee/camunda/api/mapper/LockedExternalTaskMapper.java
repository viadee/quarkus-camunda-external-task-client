package de.viadee.camunda.api.mapper;

import de.viadee.camunda.api.responses.LockedExternalTaskResponse;
import org.camunda.bpm.engine.externaltask.LockedExternalTask;

import javax.enterprise.context.ApplicationScoped;
import java.text.SimpleDateFormat;

@ApplicationScoped
public class LockedExternalTaskMapper {

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");

    public LockedExternalTaskResponse map(LockedExternalTask lockedExternalTask) {
        LockedExternalTaskResponse fetchAndLockResponse = new LockedExternalTaskResponse();
        fetchAndLockResponse.setId(lockedExternalTask.getId());
        fetchAndLockResponse.setTopicName(lockedExternalTask.getTopicName());
        fetchAndLockResponse.setWorkerId(lockedExternalTask.getWorkerId());
        fetchAndLockResponse.setLockExpirationTime(DATE_FORMAT.format(lockedExternalTask.getLockExpirationTime()));
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
