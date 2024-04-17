package com.RHLM.projectGym.mapper;

import com.RHLM.projectGym.dto.TipoSuscripcionDTO;
import com.RHLM.projectGym.model.TipoSuscripcion;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-16T22:34:08-0500",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.38.0.v20240325-1403, environment: Java 17.0.10 (Eclipse Adoptium)"
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
        if ( tipoSuscripcionDTO.getPrecio() != null ) {
            tipoSuscripcion.setPrecio( tipoSuscripcionDTO.getPrecio() );
        }
        tipoSuscripcion.setTiempo( tipoSuscripcionDTO.getTiempo() );

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
        tipoSuscripcionDTO.setPrecio( tipoSuscripcion.getPrecio() );
        tipoSuscripcionDTO.setTiempo( tipoSuscripcion.getTiempo() );

        return tipoSuscripcionDTO;
    }
}
