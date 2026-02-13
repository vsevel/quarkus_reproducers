package org.acme;

import io.quarkus.runtime.ShutdownEvent;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import jakarta.ws.rs.ApplicationPath;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

@ApplicationScoped
public class ShutdownObserver {

    Logger log = LoggerFactory.getLogger(ShutdownObserver.class);

    @ConfigProperty(name = "sleep", defaultValue = "0")
    long sleep;

    public void onShutdown(@Observes ShutdownEvent event) throws InterruptedException {
        log.info("shutting down with sleep=" + sleep);
        if(sleep != 0) {
            Thread.sleep(sleep);
            log.info("done sleep");
        }
    }
}
