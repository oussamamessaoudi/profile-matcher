package me.messaoudi.profilematcher.application.domain.entity;

import java.time.LocalDateTime;

public record Campaign(
        String game,
        String name,
        double priority,
        Matchers matchers,
        LocalDateTime startDate,
        LocalDateTime endDate,
        boolean enabled,
        LocalDateTime lastUpdated
) {
}


