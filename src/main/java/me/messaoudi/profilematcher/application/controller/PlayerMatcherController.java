package me.messaoudi.profilematcher.application.controller;

import me.messaoudi.profilematcher.application.domain.model.player.PlayerDto;
import me.messaoudi.profilematcher.application.mappers.PlayerMapper;
import me.messaoudi.profilematcher.application.service.PlayerMatcherService;
import reactor.core.publisher.Mono;

public class PlayerMatcherController {

    private final PlayerMatcherService playerMatcherService;
    private final PlayerMapper playerMapper;

    public PlayerMatcherController(PlayerMatcherService playerMatcherService, PlayerMapper playerMapper) {
        this.playerMatcherService = playerMatcherService;
        this.playerMapper = playerMapper;
    }

    public Mono<PlayerDto> getPlayer(String playerId) {
        return playerMatcherService.getPlayer(playerId).map(playerMapper::mapPlayerToPlayerDto);
    }
}
