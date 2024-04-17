package com.RHLM.projectGym.mapper;

import com.RHLM.projectGym.dto.TipoSuscripcionDTO;
import com.RHLM.projectGym.model.TipoSuscripcion;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-11T23:29:42-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.10 (Amazon.com Inc.)"
)
public class TipoSuscripcionMapperImpl implements TipoSuscripcionMapper {

    @Override
    public TipoSuscripcion toTipoSuscripcion(TipoSuscripcionDTO tipoSuscripcionDTO) {
        if ( tipoSuscripcionDTO == null ) {
            return null;
        }

        TipoSuscripcion tipoSuscripcion = new TipoSuscripcion();

        tipoSuscripcion.setId( tipoSuscripcionDTO.getId() );
        tipoSuscripcion.setNombre( tipoSuscripcionDTO.getNombre() );
        tipoSuscripcion.setTiempo( tipoSuscripcionDTO.getTiempo() );
        if ( tipoSuscripcionDTO.getPrecio() != null ) {
            tipoSuscripcion.setPrecio( tipoSuscripcionDTO.getPrecio() );
        }

        return tipoSuscripcion;
    }

    @Override
    public TipoSuscripcionDTO toTipoSuscripcionDTO(TipoSuscripcion tipoSuscripcion) {
        if ( tipoSuscripcion == null ) {
            return null;
        }

        TipoSuscripcionDTO tipoSuscripcionDTO = new TipoSuscripcionDTO();

        tipoSuscripcionDTO.setId( tipoSuscripcion.getId() );
        tipoSuscripcionDTO.setNombre( tipoSuscripcion.getNombre() );
        tipoSuscripcionDTO.setTiempo( tipoSuscripcion.getTiempo() );
        tipoSuscripcionDTO.setPrecio( tipoSuscripcion.getPrecio() );

        return tipoSuscripcionDTO;
    }
}
