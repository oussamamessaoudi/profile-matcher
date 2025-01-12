package me.messaoudi.profilematcher.application.exception;

import io.micrometer.tracing.Span;
import io.micrometer.tracing.TraceContext;
import io.micrometer.tracing.Tracer;
import me.messaoudi.profilematcher.application.domain.model.GenericError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    private final Tracer tracer;

    public GlobalExceptionHandler(Tracer tracer) {
        this.tracer = tracer;
    }

    public ResponseEntity<GenericError> handlePlayerNotFoundException(PlayerNotFoundException ex) {
        logger.warn("PlayerNotFound", ex);
        return new ResponseEntity<>(GenericError.of(ex.getMessage(), getTraceId()), HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<GenericError> handleCampaignServiceException(CampaignServiceException ex) {
        logger.error("ServiceException", ex);
        return new ResponseEntity<>(GenericError.of(ex.getMessage(), getTraceId()), HttpStatus.SERVICE_UNAVAILABLE);
    }

    public ResponseEntity<GenericError> handleException(Exception ex) {
        logger.error("Exception", ex);
        return new ResponseEntity<>(GenericError.of("API Error", getTraceId()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private String getTraceId() {
        return Optional.of(tracer)
                .map(Tracer::currentSpan)
                .map(Span::context)
                .map(TraceContext::traceId)
                .orElse("");
    }
}
