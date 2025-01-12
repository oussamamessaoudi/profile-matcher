package me.messaoudi.profilematcher.application.domain.model.player;

import java.time.LocalDateTime;

public record PlayerCampaign(String game,
                             String name,
                             double priority,
                             LocalDateTime startDate,
                             LocalDateTime endDate,
                             LocalDateTime lastUpdated) {
}
