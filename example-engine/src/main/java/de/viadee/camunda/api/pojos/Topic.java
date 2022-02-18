package de.viadee.camunda.api.pojos;

import java.util.List;

public class Topic {

    private String topicName;

    private Integer lockDuration;

    private List<String> variables;



    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public Integer getLockDuration() {
        return lockDuration;
    }

    public void setLockDuration(Integer lockDuration) {
        this.lockDuration = lockDuration;
    }

    public List<String> getVariables() {
        return variables;
    }

    public void setVariables(List<String> variables) {
        this.variables = variables;
    }

    @Override
    public String toString() {
        return "Topic{" +
                "topicName='" + topicName + '\'' +
                ", lockDuration=" + lockDuration +
                ", variables=" + variables +
                '}';
    }
}
