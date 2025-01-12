package me.messaoudi.profilematcher.infra.service;

import me.messaoudi.profilematcher.application.client.CampaignsClient;
import me.messaoudi.profilematcher.application.domain.repository.PlayerRepository;
import me.messaoudi.profilematcher.application.service.PlayerMatcherService;
import org.springframework.stereotype.Service;

@Service
public class PlayerMarcherServiceAdapter extends PlayerMatcherService {

    public PlayerMarcherServiceAdapter(PlayerRepository playerRepository, CampaignsClient campaignsClient) {
        super(playerRepository, campaignsClient);
    }

}
