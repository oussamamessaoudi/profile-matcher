package me.messaoudi.profilematcher.infra.config;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Hooks;

@Component
public class TracingConfig {

    @PostConstruct
    public void init() {
        Hooks.enableAutomaticContextPropagation();
    }
}
