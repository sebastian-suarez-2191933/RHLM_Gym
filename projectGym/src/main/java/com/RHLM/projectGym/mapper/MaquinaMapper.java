package com.RHLM.projectGym.mapper;

import com.RHLM.projectGym.dto.MaquinaDTO;
import com.RHLM.projectGym.model.Maquina;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MaquinaMapper {

    MaquinaMapper INSTANCE = Mappers.getMapper(MaquinaMapper.class);

    //DTO to Entity
    Maquina toMaquina(MaquinaDTO maquinaDTO);
    //Entity to DTO
    MaquinaDTO toMaquinaDTO(Maquina maquina);
}
