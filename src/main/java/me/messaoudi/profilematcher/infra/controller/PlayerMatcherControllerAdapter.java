package me.messaoudi.profilematcher.infra.controller;

import me.messaoudi.profilematcher.application.controller.PlayerMatcherController;
import me.messaoudi.profilematcher.application.domain.model.player.PlayerDto;
import me.messaoudi.profilematcher.application.mappers.PlayerMapper;
import me.messaoudi.profilematcher.application.service.PlayerMatcherService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/get_client_config")
public class PlayerMatcherControllerAdapter extends PlayerMatcherController {

    public PlayerMatcherControllerAdapter(PlayerMatcherService playerMatcherService, PlayerMapper playerMapper) {
        super(playerMatcherService, playerMapper);
    }

    @GetMapping("/{player_id}")
    public Mono<PlayerDto> getClientConfig(@PathVariable("player_id") String playerId) {
        return super.getPlayer(playerId);
    }
}
