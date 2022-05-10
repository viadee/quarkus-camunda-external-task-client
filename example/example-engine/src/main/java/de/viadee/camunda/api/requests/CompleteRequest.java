package de.viadee.camunda.api.requests;

import de.viadee.camunda.api.pojos.Variable;

import java.util.Map;

public class CompleteRequest {

    private String workerId;

    private Map<String, Variable> variables;

    public CompleteRequest() {
    }

    public String getWorkerId() {
        return workerId;
    }

    public void setWorkerId(String workerId) {
        this.workerId = workerId;
    }

    public Map<String, Variable> getVariables() {
        return variables;
    }

    public void setVariables(Map<String, Variable> variables) {
        this.variables = variables;
    }

    @Override
    public String toString() {
        return "CompleteRequest{" +
                "workerId='" + workerId + '\'' +
                ", variables=" + variables +
                '}';
    }
}
