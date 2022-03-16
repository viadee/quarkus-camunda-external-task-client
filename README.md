# Quarkus Camunda External Task Client
## ℹ️ Description

This project provides a Quarkus Extension that allows you to implement an External Task Worker for Camunda. It is based
on the official [java-client](https://docs.camunda.org/manual/latest/user-guide/ext-client/) provided
by [Camunda BPM](https://docs.camunda.org/manual/latest/user-guide/ext-client/).

## ⭐ Features

* Automatic topic subscription for all implementations of `ExternalTaskHanlder` annotated with `@ExternalTaskSubscription`
* Provision of a configurable `ExternalTaskClient` bean
## 🚀 How to use

1. To use the external task client Quarkus extension, the following dependency has to be added to your pom.xml.

```xml
<dependency>
    <groupId>de.viadee</groupId>
    <artifactId>quarkus-camunda-external-task-client</artifactId>
    <version>1.0.0-SNAPSHOT</version>
</dependency>
```

2. Configure the `ExternalTaskClient` bean handling the overhead of external task subscriptions by extending your `application.properties`:
```xml
de.viadee.camunda.client.base-url=http://localhost:8080/engine-rest
de.viadee.camunda.client.worker-id=my-worker
```
For a full list of properties check out the `ClientConfiguration` class.


3. Annotate your `ExternalTaskHandler` implementations with `ExternalTaskSubscription` to have them be automatically subscribed with the engine.
```java

@ApplicationScoped
@ExternalTaskSubscription(topicName = "LogOnConsole")
public class LogOnConsoleHandler implements ExternalTaskHandler {

    private static final Logger LOG = Logger.getLogger(LogOnConsoleHandler.class.getName());

    @Override
    public void execute(ExternalTask externalTask, ExternalTaskService externalTaskService) {
        LOG.info("Das ist ein Quarkus-ExternalTaskHandler");
        externalTaskService.complete(externalTask);
    }
}
```

## 🤹 Collaboration

This tool was build by viadee Unternehmensberatung AG. If you are interested to find out what else we are doing, check
out our website [viadee.de](https://www.viadee.de/en). If you have any feedback, ideas or extensions feel free to
contact or create a GitHub issue.

[comment]: <> (## 🔑 License)

[comment]: <> ([![]&#40;https://img.shields.io/github/license/viadee/quarkus-camunda-external-task-client&#41;]&#40;https://github.com/viadee/quarkus-camunda-external-task-client/blob/master/LICENSE&#41;)
