package me.messaoudi.profilematcher.application.domain.model;

import java.time.Instant;

public record GenericError(String message, Instant timestamp, String traceId) {
    public static GenericError of(String message, String traceId) {
        return new GenericError(message, Instant.now(), traceId);
    }
}
