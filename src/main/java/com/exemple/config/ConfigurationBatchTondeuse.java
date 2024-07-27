package com.exemple.config;

import com.exemple.Listener.TondeuseStepExecutionListener;
import com.exemple.service.TondeuseService;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * Configuration pour le traitement par lots Spring Batch pour l'application Tondeuse.
 * <p>
 * Cette configuration définit les beans nécessaires pour exécuter un travail de traitement par lots,
 * y compris les lecteurs, les processeurs et les écrivains d'éléments.
 *
 * @author Abdelghani KAOUSSI
 */

@Configuration
public class ConfigurationBatchTondeuse {

    @Autowired
    private TondeuseService tondeuseService;


    @Bean
    public Job jobTondeuse(JobRepository jobRepository, Step step) {
        return new JobBuilder("tondeuseJob", jobRepository)
                .incrementer(new RunIdIncrementer())
                .start(step)
                .build();
    }

    @Bean
    public Step fileProcessingStep(JobRepository jobRepository,
                                   PlatformTransactionManager platformTransactionManager,
                                   ItemReader<String> reader,
                                   ItemProcessor<String, String> processor,
                                   ItemWriter<String> writer) {
        return new StepBuilder("fileProcessingStep", jobRepository)
                .<String, String>chunk(10, platformTransactionManager)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .listener(new TondeuseStepExecutionListener())
                .build();
    }

    @Bean
    public ItemProcessor<String, String> processor() {
        return new TondeuseFileProcessor(tondeuseService);
    }

    @Bean
    public ItemReader<String> reader() {
        return new TondeuseFileReader();
    }

    @Bean
    public ItemWriter<String> writer() {
        return new TondeuseFileWriter();
    }

}
