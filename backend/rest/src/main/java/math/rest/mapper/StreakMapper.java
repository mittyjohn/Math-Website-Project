package math.rest.mapper;

import math.rest.dto.StreakDTO;
import math.rest.entity.Streak;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface StreakMapper {

    @Mapping(target = "user.username", source = "username")
    @Mapping(target = "streakDef.id", source = "streak_id")
    Streak toEntity(StreakDTO dto);

    @Mapping(target = "username", source = "user.username")
    @Mapping(target = "streak_id", source = "streakDef.id")
    StreakDTO toDTO(Streak entity);

}
