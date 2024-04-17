package com.RHLM.projectGym.mapper;

import com.RHLM.projectGym.dto.SuscripcionDTO;
import com.RHLM.projectGym.model.Suscripcion;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-16T22:34:08-0500",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.38.0.v20240325-1403, environment: Java 17.0.10 (Eclipse Adoptium)"
)
public class SuscripcionMapperImpl implements SuscripcionMapper {

    @Override
    public Suscripcion toSuscripcion(SuscripcionDTO suscripcionDTO) {
        if ( suscripcionDTO == null ) {
            return null;
        }

        Suscripcion suscripcion = new Suscripcion();

        suscripcion.setEstado( suscripcionDTO.getEstado() );
        suscripcion.setFechaFin( suscripcionDTO.getFechaFin() );
        suscripcion.setFechaInicio( suscripcionDTO.getFechaInicio() );
        suscripcion.setId( suscripcionDTO.getId() );
        suscripcion.setIdTipoSuscripcion( suscripcionDTO.getIdTipoSuscripcion() );

        return suscripcion;
    }

    @Override
    public SuscripcionDTO toSuscripcionDTO(Suscripcion suscripcion) {
        if ( suscripcion == null ) {
            return null;
        }

        SuscripcionDTO suscripcionDTO = new SuscripcionDTO();

        suscripcionDTO.setEstado( suscripcion.getEstado() );
        suscripcionDTO.setFechaFin( suscripcion.getFechaFin() );
        suscripcionDTO.setFechaInicio( suscripcion.getFechaInicio() );
        suscripcionDTO.setId( suscripcion.getId() );
        suscripcionDTO.setIdTipoSuscripcion( suscripcion.getIdTipoSuscripcion() );

        return suscripcionDTO;
    }
}
