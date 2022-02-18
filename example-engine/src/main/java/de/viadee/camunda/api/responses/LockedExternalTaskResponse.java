package de.viadee.camunda.api.responses;

import de.viadee.camunda.api.pojos.Variable;

import java.time.LocalDateTime;
import java.util.Map;

public class LockedExternalTaskResponse {

    public String id;
    public String topicName;
    public String workerId;
    public LocalDateTime lockExpirationTime;
    public String processInstanceId;
    public String executionId;
    public String activityId;
    public String activityInstanceId;
    public String processDefinitionId;
    public String processDefinitionKey;
    public String processDefinitionVersionTag;
    public Integer retries;
    public String errorMessage;
    public String errorDetails;
    public Map<String, Variable> variableMap;
    public String tenantId;
    public Long priority;
    public String businessKey;
    public Map<String, String> extensionProperties;

    public LockedExternalTaskResponse() {
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public void setWorkerId(String workerId) {
        this.workerId = workerId;
    }

    public void setLockExpirationTime(LocalDateTime lockExpirationTime) {
        this.lockExpirationTime = lockExpirationTime;
    }

    public void setProcessInstanceId(String processInstanceId) {
        this.processInstanceId = processInstanceId;
    }

    public void setExecutionId(String executionId) {
        this.executionId = executionId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }

    public void setActivityInstanceId(String activityInstanceId) {
        this.activityInstanceId = activityInstanceId;
    }

    public void setProcessDefinitionId(String processDefinitionId) {
        this.processDefinitionId = processDefinitionId;
    }

    public void setProcessDefinitionKey(String processDefinitionKey) {
        this.processDefinitionKey = processDefinitionKey;
    }

    public void setProcessDefinitionVersionTag(String processDefinitionVersionTag) {
        this.processDefinitionVersionTag = processDefinitionVersionTag;
    }

    public void setRetries(Integer retries) {
        this.retries = retries;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public void setErrorDetails(String errorDetails) {
        this.errorDetails = errorDetails;
    }

    public Map<String, Variable> getVariableMap() {
        return variableMap;
    }

    public void setVariableMap(Map<String, Variable> variableMap) {
        this.variableMap = variableMap;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public void setPriority(Long priority) {
        this.priority = priority;
    }

    public void setBusinessKey(String businessKey) {
        this.businessKey = businessKey;
    }

    public void setExtensionProperties(Map<String, String> extensionProperties) {
        this.extensionProperties = extensionProperties;
    }


    @Override
    public String toString() {
        return "LockedExternalTaskResponse{" +
                "id='" + id + '\'' +
                ", topicName='" + topicName + '\'' +
                ", workerId='" + workerId + '\'' +
                ", lockExpirationTime='" + lockExpirationTime + '\'' +
                ", processInstanceId='" + processInstanceId + '\'' +
                ", executionId='" + executionId + '\'' +
                ", activityId='" + activityId + '\'' +
                ", activityInstanceId='" + activityInstanceId + '\'' +
                ", processDefinitionId='" + processDefinitionId + '\'' +
                ", processDefinitionKey='" + processDefinitionKey + '\'' +
                ", processDefinitionVersionTag='" + processDefinitionVersionTag + '\'' +
                ", retries=" + retries +
                ", errorMessage='" + errorMessage + '\'' +
                ", errorDetails='" + errorDetails + '\'' +
                ", variableMap=" + variableMap +
                ", tenantId='" + tenantId + '\'' +
                ", priority=" + priority +
                ", businessKey='" + businessKey + '\'' +
                ", extensionProperties=" + extensionProperties +
                '}';
    }
}
