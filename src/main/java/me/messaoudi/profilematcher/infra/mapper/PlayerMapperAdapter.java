package me.messaoudi.profilematcher.infra.mapper;

import me.messaoudi.profilematcher.application.mappers.PlayerMapper;
import org.mapstruct.Mapper;

@Mapper(uses = PlayerMapper.class)
public interface PlayerMapperAdapter extends PlayerMapper {
}
