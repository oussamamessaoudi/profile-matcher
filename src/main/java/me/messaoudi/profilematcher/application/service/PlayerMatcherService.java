package me.messaoudi.profilematcher.application.service;

import me.messaoudi.profilematcher.application.client.CampaignsClient;
import me.messaoudi.profilematcher.application.domain.entity.Campaign;
import me.messaoudi.profilematcher.application.domain.entity.Player;
import me.messaoudi.profilematcher.application.domain.repository.PlayerRepository;
import me.messaoudi.profilematcher.application.exception.CampaignServiceException;
import me.messaoudi.profilematcher.application.exception.PlayerNotFoundException;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;


public class PlayerMatcherService {

    private final PlayerRepository playerRepository;
    private final CampaignsClient campaignsClient;

    public PlayerMatcherService(PlayerRepository playerRepository, CampaignsClient campaignsClient) {
        this.playerRepository = playerRepository;
        this.campaignsClient = campaignsClient;
    }

    @Transactional
    public Mono<Player> getPlayer(String playerId) {
        return playerRepository.findById(playerId)
                .switchIfEmpty(Mono.error(new PlayerNotFoundException(playerId)))
                .flatMap(player -> campaignsClient.fetchCurrentCampaigns()
                        .filter(campaign -> matchesCampaign(player, campaign))
                        .collect(Collectors.toSet())
                        .filter(campaigns -> !campaigns.equals(player.campaigns()))
                        .flatMap(campaigns -> {
                            var playerUpdated = updatePlayerWithCampaign(player, campaigns);
                            return playerRepository.save(playerUpdated);
                        })
                        .switchIfEmpty(Mono.just(player))
                        .onErrorMap(e -> new CampaignServiceException(e.getMessage()))
                );
    }

    private boolean matchesCampaign(Player p, Campaign campaign) {
        LocalDateTime now = LocalDateTime.now();
        return Optional.of(campaign)
                .filter(Campaign::enabled)
                .filter(c -> c.startDate().isBefore(now))
                .filter(c -> c.endDate().isAfter(now))
                .map(Campaign::matchers)
                .filter(m -> p.level() <= m.level().max())
                .filter(m -> p.level() >= m.level().min())
                .filter(m -> m.has().country().contains(p.country()))
                .filter(m -> p.inventory().keySet().containsAll(m.has().items()))
                .filter(m -> m.doesNotHave().items().stream().noneMatch(p.inventory()::containsKey))
                .isPresent();
    }

    private Player updatePlayerWithCampaign(Player player, Set<Campaign> campaigns) {

        return new Player(
                player.playerId(),
                player.credential(),
                player.created(),
                LocalDateTime.now(),
                player.lastSession(),
                player.totalSpent(),
                player.totalRefund(),
                player.totalTransactions(),
                player.lastPurchase(),
                campaigns,
                player.devices(),
                player.level(),
                player.xp(),
                player.totalPlaytime(),
                player.country(),
                player.language(),
                player.birthdate(),
                player.gender(),
                player.inventory(), // You can update this map if needed
                player.clan()
        );
    }
}
