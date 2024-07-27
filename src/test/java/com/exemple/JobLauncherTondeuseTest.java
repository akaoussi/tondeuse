package com.exemple;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
public class JobLauncherTondeuseTest {

    @Mock
    private JobLauncher jobLauncher;

    @Mock
    private Job job;

    @InjectMocks
    private JobLauncherTondeuse jobLauncherTondeuse;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testRunJobSuccess() throws Exception {
        JobExecution jobExecution = mock(JobExecution.class);
        when(jobLauncher.run(any(Job.class), any(JobParameters.class))).thenReturn(jobExecution);

        jobLauncherTondeuse.runJob();

        verify(jobLauncher, times(1)).run(any(Job.class), any(JobParameters.class));
        System.out.println("Job executed successfully.");
    }

    @Test
    public void testRunJobFailure() throws Exception {
        when(jobLauncher.run(any(Job.class), any(JobParameters.class))).thenThrow(new RuntimeException("Job execution failed."));

        jobLauncherTondeuse.runJob();

        verify(jobLauncher, times(1)).run(any(Job.class), any(JobParameters.class));
        System.err.println("Job execution failed.");
    }
}
