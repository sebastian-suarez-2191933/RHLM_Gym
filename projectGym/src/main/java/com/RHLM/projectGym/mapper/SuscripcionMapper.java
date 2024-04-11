package com.RHLM.projectGym.mapper;

import com.RHLM.projectGym.dto.SuscripcionDTO;
import com.RHLM.projectGym.model.Suscripcion;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SuscripcionMapper {

    SuscripcionMapper INSTANCE = Mappers.getMapper(SuscripcionMapper.class);

    //DTO to Entity
    Suscripcion toSuscripcion(SuscripcionDTO suscripcionDTO);

    //Entity to DTO
    SuscripcionDTO toSuscripcionDTO(Suscripcion suscripcion);
}
