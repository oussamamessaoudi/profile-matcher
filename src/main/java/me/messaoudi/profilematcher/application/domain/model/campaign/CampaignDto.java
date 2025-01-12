package me.messaoudi.profilematcher.application.domain.model.campaign;

import java.time.LocalDateTime;

public record CampaignDto(
        String game,
        String name,
        double priority,
        MatchersDto matchers,
        LocalDateTime startDate,
        LocalDateTime endDate,
        boolean enabled,
        LocalDateTime lastUpdated
) {
}


