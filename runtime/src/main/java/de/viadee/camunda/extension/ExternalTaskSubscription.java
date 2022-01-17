package de.viadee.camunda.extension;


import io.quarkus.arc.Unremovable;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Unremovable
public @interface ExternalTaskSubscription {
    String topicName() default "";
}
