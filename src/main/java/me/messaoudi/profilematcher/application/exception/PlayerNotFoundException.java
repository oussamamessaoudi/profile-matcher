package me.messaoudi.profilematcher.application.exception;

public class PlayerNotFoundException extends RuntimeException {
    public PlayerNotFoundException(String playerId) {
        super("Player with ID " + playerId + " not found.");
    }
}