package me.messaoudi.profilematcher.application.domain.entity;

import java.util.List;

public record Has(
        List<String> country,
        List<String> items
) {}
