package org.rest.resource.ms.batch.listener;

import jakarta.batch.api.listener.JobListener;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.jboss.logging.Logger;

@ApplicationScoped
@Named(value = "artistJobListener")
public class ArtistJobListener implements JobListener {

    @Inject
    private Logger logger;

    @Override
    public void beforeJob() {
        logger.info("Batch job started");
    }

    @Override
    public void afterJob() {
        logger.info("Batch job completed");
    }
}
