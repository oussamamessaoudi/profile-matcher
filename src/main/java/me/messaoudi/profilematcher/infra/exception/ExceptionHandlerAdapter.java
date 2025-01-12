package me.messaoudi.profilematcher.infra.exception;

import io.micrometer.tracing.Tracer;
import me.messaoudi.profilematcher.application.domain.model.GenericError;
import me.messaoudi.profilematcher.application.exception.CampaignServiceException;
import me.messaoudi.profilematcher.application.exception.GlobalExceptionHandler;
import me.messaoudi.profilematcher.application.exception.PlayerNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class ExceptionHandlerAdapter extends GlobalExceptionHandler {

    public ExceptionHandlerAdapter(Tracer tracer) {
        super(tracer);
    }

    @Override
    @ExceptionHandler(PlayerNotFoundException.class)
    public ResponseEntity<GenericError> handlePlayerNotFoundException(PlayerNotFoundException ex) {
        return super.handlePlayerNotFoundException(ex);
    }

    @Override
    @ExceptionHandler(CampaignServiceException.class)
    public ResponseEntity<GenericError> handleCampaignServiceException(CampaignServiceException ex) {
        return super.handleCampaignServiceException(ex);
    }

    @Override
    @ExceptionHandler(Exception.class)
    public ResponseEntity<GenericError> handleException(Exception ex) {
        return super.handleException(ex);
    }
}
