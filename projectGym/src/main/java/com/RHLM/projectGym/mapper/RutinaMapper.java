package com.RHLM.projectGym.mapper;

import com.RHLM.projectGym.dto.RutinaDTO;
import com.RHLM.projectGym.model.Rutina;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RutinaMapper {
    RutinaMapper INSTANCE = Mappers.getMapper(RutinaMapper.class);

    //DTO to Entity
    Rutina toRutina(RutinaDTO rutinaDTO);

    //Entity to DTO
    @Mapping(target = "nombreMaquina", source = "maquina.nombre")
    RutinaDTO toRutinaDTO(Rutina rutina);

}
