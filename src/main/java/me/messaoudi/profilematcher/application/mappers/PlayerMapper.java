package me.messaoudi.profilematcher.application.mappers;

import me.messaoudi.profilematcher.application.domain.entity.Player;
import me.messaoudi.profilematcher.application.domain.model.player.PlayerDto;

public interface PlayerMapper {
    PlayerDto mapPlayerToPlayerDto(Player player);
}
