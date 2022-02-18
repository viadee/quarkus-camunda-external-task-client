package de.viadee.camunda.extension;

import io.quarkus.runtime.annotations.ConfigItem;
import io.quarkus.runtime.annotations.ConfigPhase;
import io.quarkus.runtime.annotations.ConfigRoot;

import java.util.ArrayList;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.OptionalLong;

@ConfigRoot(phase = ConfigPhase.RUN_TIME, prefix = "de.viadee.camunda")
public class ClientConfiguration {

    /**
     * Camunda Rest Api base url
     */
    @ConfigItem(defaultValue = "http://localhost:8080/engine-rest")
    public String baseUrl;
    /**
     * This worker's id
     */
    @ConfigItem(defaultValue = "")
    public Optional<String> workerID;
    /**
     * maximum number of tasks to be fetched at once
     */
    @ConfigItem
    public OptionalInt maxTasks;
    /**
     * choose whether to respect or ignore task priority
     */
    @ConfigItem
    public Optional<Boolean> usePriority;
    /**
     * set serialization format. Default is application/json
     */
    @ConfigItem
    public Optional<String> defaultSerializationFormat;

    /**
     * set date format
     */
    @ConfigItem
    public Optional<String> dateFormat;
    /**
     * set timeout for long polling
     */
    @ConfigItem
    public OptionalLong asyncResponseTimeout;
    /**
     * set duration for which to lock tasks
     */
    @ConfigItem
    public OptionalLong lockDuration;
    /**
     * disable automatic task fetching
     */
    @ConfigItem
    public Optional<Boolean> disableAutoFetching;
    /**
     * disable backoff strategy. Be aware that this might lead to considerable amounts of traffic, even if no tasks are present
     */
    @ConfigItem
    public Optional<Boolean> disableBackoffStrategy;

}
