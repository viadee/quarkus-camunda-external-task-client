package de.viadee.minimalengine;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.spring.boot.starter.annotation.EnableProcessApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableProcessApplication("MinimalCamundaEngine")
@EnableScheduling
public class CamundaApplication {
  private static final Logger LOGGER = LoggerFactory.getLogger(CamundaApplication.class);

  public static void main(String... args) {
    SpringApplication.run(CamundaApplication.class, args);
  }

  private final RuntimeService runtimeService;

  public CamundaApplication(final RuntimeService runtimeService) {
    this.runtimeService = runtimeService;
  }

  @Scheduled(initialDelay = 20L * 1000L, fixedDelay = 20L * 1000L) // every 20 seconds after 20 seconds delay
  public void startWorkerProcess() {
    this.runtimeService.startProcessInstanceByKey("MinimalCamundaEngine");
    LOGGER.info("started Process!");
  }
}
