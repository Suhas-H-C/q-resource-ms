package org.rest.resource.ms.batch;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.batch.operations.JobOperator;
import jakarta.batch.runtime.BatchRuntime;
import jakarta.batch.runtime.BatchStatus;
import org.junit.jupiter.api.Test;

import java.util.Properties;

import static org.junit.jupiter.api.Assertions.assertEquals;

@QuarkusTest
public class BatchJobStarterTest {

    @Test
    void testArtistBatchJobRunsSuccessfully() throws Exception {
        JobOperator jobOperator = BatchRuntime.getJobOperator();
        long executionId = jobOperator.start("artist-insert-job", new Properties());
        BatchStatus batchStatus;
        do {
            Thread.sleep(100);
            batchStatus = jobOperator.getJobExecution(executionId).getBatchStatus();
        } while (batchStatus == BatchStatus.STARTING || batchStatus == BatchStatus.STARTED);
        assertEquals(BatchStatus.COMPLETED, batchStatus, "Batch job should complete successfully");
    }
}