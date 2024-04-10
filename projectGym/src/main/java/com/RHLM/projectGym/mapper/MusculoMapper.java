package com.RHLM.projectGym.mapper;
import com.RHLM.projectGym.dto.MusculoDTO;
import com.RHLM.projectGym.model.Musculo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MusculoMapper {
    MusculoMapper INSTANCE = Mappers.getMapper(MusculoMapper.class);

    //DTO to Entity
    Musculo toMusculo(MusculoDTO musculoDTO);
    MusculoDTO toMusculoDTO(Musculo musculo);
}
