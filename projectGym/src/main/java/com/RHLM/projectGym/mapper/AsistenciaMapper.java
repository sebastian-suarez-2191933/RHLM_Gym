package com.RHLM.projectGym.mapper;

import com.RHLM.projectGym.dto.AsistenciaDTO;
import com.RHLM.projectGym.model.Asistencia;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AsistenciaMapper {

    AsistenciaMapper INSTANCE = Mappers.getMapper(AsistenciaMapper.class);

    //DTO to Entity
    Asistencia toAsistencia(AsistenciaDTO asistenciaDTO);

    //Entity to DTO
    @Mapping(target = "nombreUsuario", source = "usuario.persona.nombre")
    @Mapping(target = "nombreRutina", source = "rutina.nombre")
    @Mapping(target = "fechaInicio", source = "usuario.suscripcion.fechaInicio")
    @Mapping(target = "fechaFin", source = "usuario.suscripcion.fechaFin")
    @Mapping(target = "estado", source = "usuario.suscripcion.estado")
    @Mapping(target = "nombreSuscripcion", source = "usuario.suscripcion.tipoSuscripcion.nombre")
    AsistenciaDTO toAsistenciaDTO(Asistencia asistencia);
}
