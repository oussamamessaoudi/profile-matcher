package me.messaoudi.profilematcher.application.domain.model.player;


import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;


@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record PlayerDto(
        String playerId,
        LocalDateTime created,
        LocalDateTime modified,
        LocalDateTime lastSession,
        int totalSpent,
        int totalRefund,
        int totalTransactions,
        LocalDateTime lastPurchase,
        List<PlayerCampaign> campaigns,
        List<DeviceDto> devices,
        int level,
        int xp,
        int totalPlaytime,
        String country,
        String language,
        LocalDateTime birthdate,
        String gender,
        Map<String, Integer> inventory,
        ClanDto clan
) {}

