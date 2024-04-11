package com.RHLM.projectGym.mapper;

import com.RHLM.projectGym.dto.SuscripcionDTO;
import com.RHLM.projectGym.model.Suscripcion;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-11T05:03:27-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.10 (Amazon.com Inc.)"
)
public class SuscripcionMapperImpl implements SuscripcionMapper {

    @Override
    public Suscripcion toSuscripcion(SuscripcionDTO suscripcionDTO) {
        if ( suscripcionDTO == null ) {
            return null;
        }

        Suscripcion suscripcion = new Suscripcion();

        suscripcion.setId( suscripcionDTO.getId() );
        suscripcion.setIdTipoSuscripcion( suscripcionDTO.getIdTipoSuscripcion() );
        suscripcion.setFechaInicio( suscripcionDTO.getFechaInicio() );
        suscripcion.setFechaFin( suscripcionDTO.getFechaFin() );
        suscripcion.setEstado( suscripcionDTO.getEstado() );

        return suscripcion;
    }

    @Override
    public SuscripcionDTO toSuscripcionDTO(Suscripcion suscripcion) {
        if ( suscripcion == null ) {
            return null;
        }

        SuscripcionDTO suscripcionDTO = new SuscripcionDTO();

        suscripcionDTO.setId( suscripcion.getId() );
        suscripcionDTO.setIdTipoSuscripcion( suscripcion.getIdTipoSuscripcion() );
        suscripcionDTO.setFechaInicio( suscripcion.getFechaInicio() );
        suscripcionDTO.setFechaFin( suscripcion.getFechaFin() );
        suscripcionDTO.setEstado( suscripcion.getEstado() );

        return suscripcionDTO;
    }
}
