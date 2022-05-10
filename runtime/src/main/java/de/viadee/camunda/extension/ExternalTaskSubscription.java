package de.viadee.camunda.extension;


import io.quarkus.arc.Unremovable;
import org.camunda.bpm.client.task.ExternalTaskHandler;
import org.camunda.bpm.client.topic.TopicSubscriptionBuilder;

import java.lang.annotation.*;
import java.util.Map;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface ExternalTaskSubscription {
    String topicName() default "";

    String[] variableNames() default "";

    boolean localVariables() default false;


    String businessKey() default "";

    String processDefinitionId() default "";


    String[] processDefinitionIdIn() default "";


    String processDefinitionKey() default "";


    String[] processDefinitionKeyIn() default "";


    String processDefinitionVersionTag() default "";


    String[] tenantIdIn() default "";

    boolean includeExtensionProperties() default false;
}
