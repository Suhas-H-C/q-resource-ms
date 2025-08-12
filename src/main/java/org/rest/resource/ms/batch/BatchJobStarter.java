package org.rest.resource.ms.batch;

import io.quarkus.runtime.StartupEvent;
import jakarta.batch.runtime.BatchRuntime;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import java.util.Properties;

@ApplicationScoped
public class BatchJobStarter {

    @ConfigProperty(name = "quarkus.batch.run.startup", defaultValue = "true")
    boolean runOnStartup;

    public void start(@Observes StartupEvent startupEvent) {
        if (runOnStartup) {
            BatchRuntime.getJobOperator().start("artist-insert-job", new Properties());
        }
    }
}