package com.exemple;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


/**
 * Classe principale pour lancer le job Spring Batch pour la tondeuse.
 * <p>
 * Cette classe démarre l'application Spring Boot et exécute le job Spring Batch
 * pour traiter les instructions de la tondeuse à partir d'un fichier d'entrée.
 *
 * @autor Abdelghani KAOUSSI
 */

@SpringBootApplication
public class JobLauncherTondeuse {

    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    private Job job;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(JobLauncherTondeuse.class, args);
        JobLauncherTondeuse app = context.getBean(JobLauncherTondeuse.class);
        app.runJob();
    }

    public void runJob() {
        try {
            JobParameters params = new JobParametersBuilder()
                    .addLong("startAt", System.currentTimeMillis()).toJobParameters();
            jobLauncher.run(job, params);
            System.out.println("Job executed successfully.");
        } catch (Exception e) {
            System.err.println("Job execution failed.");
            e.printStackTrace();
        }
    }
}
