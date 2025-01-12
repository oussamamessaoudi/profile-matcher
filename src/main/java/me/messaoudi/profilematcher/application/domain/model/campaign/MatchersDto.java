package me.messaoudi.profilematcher.application.domain.model.campaign;

public record MatchersDto(
        RangeDto level,
        HasDto has,
        DoesNotHaveDto doesNotHave
) {}
