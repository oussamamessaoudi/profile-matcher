package me.messaoudi.profilematcher.application.domain.entity;

public record Device(
        int id,
        String model,
        String carrier,
        String firmware
) {}
