package me.messaoudi.profilematcher.application.domain.entity;


import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;


@Document(collection = "players")
public record Player(
        @Id
        String playerId,
        String credential,
        @CreatedDate
        LocalDateTime created,
        @LastModifiedDate
        LocalDateTime modified,
        LocalDateTime lastSession,
        int totalSpent,
        int totalRefund,
        int totalTransactions,
        LocalDateTime lastPurchase,
        Set<Campaign> campaigns,
        List<Device> devices,
        int level,
        int xp,
        int totalPlaytime,
        String country,
        String language,
        LocalDateTime birthdate,
        String gender,
        Map<String, Integer> inventory,
        Clan clan
) {}

