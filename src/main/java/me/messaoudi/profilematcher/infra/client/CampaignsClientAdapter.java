package me.messaoudi.profilematcher.infra.client;

import me.messaoudi.profilematcher.application.client.CampaignsClient;
import me.messaoudi.profilematcher.application.mappers.CampaignMapper;
import org.springframework.stereotype.Service;

@Service
public class CampaignsClientAdapter extends CampaignsClient {
    public CampaignsClientAdapter(CampaignMapper campaignMapper) {
        super(campaignMapper);
    }
}
