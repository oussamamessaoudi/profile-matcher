package me.messaoudi.profilematcher.application.domain.model.player;

public record DeviceDto(
        int id,
        String model,
        String carrier,
        String firmware
) {}
