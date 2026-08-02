package math.rest.mapper;

import math.rest.dto.UserDTO;
import math.rest.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {

    User toEntity(UserDTO dto);
    UserDTO toDTO(User entity);
    @Mapping(target = "password", ignore = true)
    void updateEntityFromDto(UserDTO dto, @MappingTarget User entity);

}
