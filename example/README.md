# Quarkus External Task Client Example

This example showcases the functionality of the Quarkus External Task Worker. 
It consists of two submodules. The first module is the Camunda Process Engine build with the [Camunda Quarkus Extension](https://github.com/camunda/camunda-bpm-platform/tree/master/quarkus-extension).
This engine deploys a simple process with two external tasks (see below).
It also provides an interface to the camunda services, which is not included with the used extension.

![Example Process](example-engine/src/main/resources/process.png)

The second module includes the implementations of the external tasks using the Quarkus-External-Task extension.
The implementations are using the ``ExternalTaskSubscription`` annotation to subscribe to the topic of the process (see below).

```java

@ApplicationScoped
@ExternalTaskSubscription(topicName = "LogOnConsole")
public class LogOnConsoleHandler implements ExternalTaskHandler {

    private static final Logger LOG = Logger.getLogger(LogOnConsoleHandler.class.getName());

    @Override
    public void execute(ExternalTask externalTask, ExternalTaskService externalTaskService) {
        LOG.info("This is an ExternalTaskHandler build with Quarkus");
        externalTaskService.complete(externalTask);
    }
}
```

## Start the engine

```
    cd example-engine && ./mvnw quarkus:dev
```

## Create a process instance

```
    curl http://localhost:8080/start-process
```

## Start the external task client

```
    cd example-process && ./mvnw quarkus:dev
```