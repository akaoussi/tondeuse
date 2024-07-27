package com.exemple.Listener;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.listener.StepExecutionListenerSupport;

import java.time.LocalDateTime;

public class TondeuseStepExecutionListener extends StepExecutionListenerSupport {

    /**
     * Listener pour l'exécution des étapes dans le traitement par lots.
     * <p>
     * Ce listener fournit des méthodes de rappel avant et après l'exécution d'une étape de traitement par lots,
     * permettant d'exécuter du code personnalisé avant et après l'étape.
     *
     * @author Abdelghani KAOUSSI
     */

    @Override
    public void beforeStep(StepExecution stepExecution) {
        stepExecution.setStartTime(LocalDateTime.now());
    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        stepExecution.setEndTime(LocalDateTime.now());
        return stepExecution.getExitStatus();
    }
}
