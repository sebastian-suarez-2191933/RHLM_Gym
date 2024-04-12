package com.RHLM.projectGym.mapper;

import com.RHLM.projectGym.dto.MaquinaMusculoDTO;
import com.RHLM.projectGym.model.Maquina;
import com.RHLM.projectGym.model.MaquinaMusculo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MaquinaMusculoMapper {
    MaquinaMusculoMapper INSTANCE = Mappers.getMapper(MaquinaMusculoMapper.class);

    //DTO to Entity
    MaquinaMusculo toMaquinaMusculo(MaquinaMusculoDTO maquinaMusculoDTO);

    //Entity to DTO
    @Mapping(target = "nombreMaquina", source = "maquina.nombre")
    @Mapping(target = "nombreMusculo", source = "musculo.nombre")
    MaquinaMusculoDTO toMaquinaMusculoDTO(MaquinaMusculo maquinaMusculo);

}
