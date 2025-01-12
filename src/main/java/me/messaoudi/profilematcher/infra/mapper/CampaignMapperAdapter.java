package me.messaoudi.profilematcher.infra.mapper;

import me.messaoudi.profilematcher.application.mappers.CampaignMapper;
import org.mapstruct.Mapper;

@Mapper(uses = CampaignMapper.class)
public interface CampaignMapperAdapter extends CampaignMapper {
}
