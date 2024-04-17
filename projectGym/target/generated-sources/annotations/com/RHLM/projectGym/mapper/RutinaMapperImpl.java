package com.RHLM.projectGym.mapper;

import com.RHLM.projectGym.dto.RutinaDTO;
import com.RHLM.projectGym.model.Maquina;
import com.RHLM.projectGym.model.Rutina;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-16T22:34:08-0500",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.38.0.v20240325-1403, environment: Java 17.0.10 (Eclipse Adoptium)"
)
public class RutinaMapperImpl implements RutinaMapper {

    @Override
    public Rutina toRutina(RutinaDTO rutinaDTO) {
        if ( rutinaDTO == null ) {
            return null;
        }

        Rutina rutina = new Rutina();

        rutina.setDescripcion( rutinaDTO.getDescripcion() );
        rutina.setId( rutinaDTO.getId() );
        rutina.setIdMaquina( rutinaDTO.getIdMaquina() );
        rutina.setNombre( rutinaDTO.getNombre() );

        return rutina;
    }

    @Override
    public RutinaDTO toRutinaDTO(Rutina rutina) {
        if ( rutina == null ) {
            return null;
        }

        RutinaDTO rutinaDTO = new RutinaDTO();

        rutinaDTO.setNombreMaquina( rutinaMaquinaNombre( rutina ) );
        rutinaDTO.setDescripcion( rutina.getDescripcion() );
        rutinaDTO.setId( rutina.getId() );
        rutinaDTO.setIdMaquina( rutina.getIdMaquina() );
        rutinaDTO.setNombre( rutina.getNombre() );

        return rutinaDTO;
    }

    private String rutinaMaquinaNombre(Rutina rutina) {
        if ( rutina == null ) {
            return null;
        }
        Maquina maquina = rutina.getMaquina();
        if ( maquina == null ) {
            return null;
        }
        String nombre = maquina.getNombre();
        if ( nombre == null ) {
            return null;
        }
        return nombre;
    }
}
