package de.viadee.minimalengine.listener;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class ProcessCompletedListener implements ExecutionListener {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProcessCompletedListener.class);

    @Override
    public void notify(DelegateExecution delegateExecution) {
        LOGGER.info("Completed Process with id {}", delegateExecution.getProcessInstanceId());

    }
}
