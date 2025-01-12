package me.messaoudi.profilematcher.application.mappers;

import me.messaoudi.profilematcher.application.domain.entity.Campaign;
import me.messaoudi.profilematcher.application.domain.model.campaign.CampaignDto;

public interface CampaignMapper {
    Campaign mapCampaignDtoToCampaign(CampaignDto campaign);
}
