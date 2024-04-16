package com.RHLM.projectGym.mapper;

import com.RHLM.projectGym.dto.RutinaDTO;
import com.RHLM.projectGym.model.Maquina;
import com.RHLM.projectGym.model.Rutina;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-16T15:14:29-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.10 (Amazon.com Inc.)"
)
public class RutinaMapperImpl implements RutinaMapper {

    @Override
    public Rutina toRutina(RutinaDTO rutinaDTO) {
        if ( rutinaDTO == null ) {
            return null;
        }

        Rutina rutina = new Rutina();

        rutina.setId( rutinaDTO.getId() );
        rutina.setNombre( rutinaDTO.getNombre() );
        rutina.setIdMaquina( rutinaDTO.getIdMaquina() );
        rutina.setDescripcion( rutinaDTO.getDescripcion() );

        return rutina;
    }

    @Override
    public RutinaDTO toRutinaDTO(Rutina rutina) {
        if ( rutina == null ) {
            return null;
        }

        RutinaDTO rutinaDTO = new RutinaDTO();

        rutinaDTO.setNombreMaquina( rutinaMaquinaNombre( rutina ) );
        rutinaDTO.setId( rutina.getId() );
        rutinaDTO.setNombre( rutina.getNombre() );
        rutinaDTO.setIdMaquina( rutina.getIdMaquina() );
        rutinaDTO.setDescripcion( rutina.getDescripcion() );

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
