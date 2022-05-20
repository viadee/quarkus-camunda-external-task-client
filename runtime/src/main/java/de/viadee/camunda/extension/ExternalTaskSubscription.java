package de.viadee.camunda.extension;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

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
