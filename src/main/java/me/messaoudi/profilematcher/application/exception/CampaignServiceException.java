package me.messaoudi.profilematcher.application.exception;

public class CampaignServiceException extends RuntimeException {
    public CampaignServiceException(String message) {
        super("Campaign service error: " + message);
    }
}
