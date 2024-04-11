package com.RHLM.projectGym.mapper;

import com.RHLM.projectGym.dto.TipoSuscripcionDTO;
import com.RHLM.projectGym.model.TipoSuscripcion;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TipoSuscripcionMapper {

    TipoSuscripcionMapper INSTANCE = Mappers.getMapper(TipoSuscripcionMapper.class);

    //DTO to Entity
    TipoSuscripcion toTipoSuscripcion(TipoSuscripcionDTO tipoSuscripcionDTO);

    //Entity to DTO
    TipoSuscripcionDTO toTipoSuscripcionDTO(TipoSuscripcion tipoSuscripcion);
}
