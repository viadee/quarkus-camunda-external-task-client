package de.viadee.camunda.extension;


import io.quarkus.arc.Unremovable;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface ExternalTaskSubscription {
    String topicName() default "";
}
