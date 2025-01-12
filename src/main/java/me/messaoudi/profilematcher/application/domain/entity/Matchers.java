package me.messaoudi.profilematcher.application.domain.entity;

public record Matchers(
        Range level,
        Has has,
        DoesNotHave doesNotHave
) {}
