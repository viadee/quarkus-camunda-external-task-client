package de.viadee.camunda.api.requests;

import de.viadee.camunda.api.pojos.Topic;

import java.util.List;


public class FetchAndLockRequest {

    private String workerId;

    private Integer maxTasks;

    private Boolean usePriority;

    private List<Topic> topics;

    public FetchAndLockRequest() {

    }

    public String getWorkerId() {
        return workerId;
    }

    public void setWorkerId(String workerId) {
        this.workerId = workerId;
    }

    public Integer getMaxTasks() {
        return maxTasks;
    }

    public Boolean getUsePriority() {
        return usePriority;
    }

    public void setUsePriority(Boolean usePriority) {
        this.usePriority = usePriority;
    }

    public void setMaxTasks(Integer maxTasks) {
        this.maxTasks = maxTasks;
    }

    public List<Topic> getTopics() {
        return topics;
    }

    public void setTopics(List<Topic> topics) {
        this.topics = topics;
    }


    @Override
    public String toString() {
        return "FetchAndLockRequest{" +
                "workerId='" + workerId + '\'' +
                ", maxTasks=" + maxTasks +
                ", usePriority=" + usePriority +
                ", topics=" + topics +
                '}';
    }
}
