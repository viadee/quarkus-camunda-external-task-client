package de.viadee.camunda.extension;

import io.quarkus.runtime.annotations.Recorder;
import org.camunda.bpm.client.ExternalTaskClient;
import org.camunda.bpm.client.impl.ExternalTaskClientBuilderImpl;

import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import java.util.function.Supplier;

@Recorder
public class ExternalTaskClientCreationRecorder{

//    private ClientConfiguration clientConfiguration;
//
//    @Inject
//    public ExternalTaskClientCreationRecorder (ClientConfiguration config) {
//        this.clientConfiguration = config;
//    }

   public Supplier<ExternalTaskClient> getSupplier(ClientConfiguration config) {
       return () -> {
           var builder = new ExternalTaskClientBuilderImpl();
           return builder
                   .baseUrl(config.getBaseUrl())
                   .workerId("configuration.getWorkerID()")
                   .lockDuration(13)
                   .maxTasks(10)
                   .build();
       };
   }



}
