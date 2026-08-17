package math.rest.mapper;

import math.rest.dto.QuestionDTO;
import math.rest.entity.Question;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface QuestionMapper {

    Question toEntity(QuestionDTO dto);
    QuestionDTO toDTO(Question entity);
    @Mapping(target = "id", ignore = true)
    void updateEntityFromDto(QuestionDTO dto, @MappingTarget Question entity);

}
