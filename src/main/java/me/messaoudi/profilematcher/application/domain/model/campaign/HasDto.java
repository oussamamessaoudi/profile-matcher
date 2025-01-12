package me.messaoudi.profilematcher.application.domain.model.campaign;

import java.util.List;

public record HasDto(
        List<String> country,
        List<String> items
) {}
