package me.messaoudi.profilematcher.application.client;

import me.messaoudi.profilematcher.application.domain.entity.Campaign;
import me.messaoudi.profilematcher.application.domain.model.campaign.*;
import me.messaoudi.profilematcher.application.mappers.CampaignMapper;
import reactor.core.publisher.Flux;

import java.time.LocalDateTime;
import java.util.List;

public class CampaignsClient {

    private final CampaignMapper campaignMapper;

    public CampaignsClient(CampaignMapper campaignMapper) {
        this.campaignMapper = campaignMapper;
    }

    public Flux<Campaign> fetchCurrentCampaigns() {
        // Mock API call to fetch current campaigns
        // Replace with actual API call logic
        return Flux.just(
                new CampaignDto(
                        "mygame",
                        "mycampaign",
                        10.5,
                        new MatchersDto(
                                new RangeDto(1, 3),
                                new HasDto(List.of("US", "RO", "CA"), List.of("item_1")),
                                new DoesNotHaveDto(List.of("item_4"))
                        ),
                        LocalDateTime.parse("2025-01-10T00:00:00"),
                        LocalDateTime.parse("2025-02-25T00:00:00"),
                        true,
                        LocalDateTime.parse("2021-07-13T11:46:58")
                )
        ).map(campaignMapper::mapCampaignDtoToCampaign);
    }
}
