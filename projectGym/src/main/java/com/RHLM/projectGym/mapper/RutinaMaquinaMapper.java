package com.RHLM.projectGym.mapper;

import com.RHLM.projectGym.dto.RutinaMaquinaDTO;
import com.RHLM.projectGym.model.RutinaMaquina;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RutinaMaquinaMapper {

    RutinaMaquinaMapper INSTANCE = Mappers.getMapper(RutinaMaquinaMapper.class);

    //DTO to Entity
    RutinaMaquina toRutinaMaquina(RutinaMaquinaDTO rutinaMaquinaDTO);

    //Entity to DTO
    @Mapping(target = "nombreRutina", source = "rutina.nombre")
    @Mapping(target = "nombreMaquina", source = "maquina.nombre")
    RutinaMaquinaDTO toRutinaMaquinaDTO(RutinaMaquina rutinaMaquina);
}
