package com.RHLM.projectGym.mapper;

import com.RHLM.projectGym.dto.RutinaMaquinaDTO;
import com.RHLM.projectGym.model.Maquina;
import com.RHLM.projectGym.model.Rutina;
import com.RHLM.projectGym.model.RutinaMaquina;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-16T22:34:08-0500",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.38.0.v20240325-1403, environment: Java 17.0.10 (Eclipse Adoptium)"
)
public class RutinaMaquinaMapperImpl implements RutinaMaquinaMapper {

    @Override
    public RutinaMaquina toRutinaMaquina(RutinaMaquinaDTO rutinaMaquinaDTO) {
        if ( rutinaMaquinaDTO == null ) {
            return null;
        }

        RutinaMaquina rutinaMaquina = new RutinaMaquina();

        rutinaMaquina.setId( rutinaMaquinaDTO.getId() );
        rutinaMaquina.setIdMaquina( rutinaMaquinaDTO.getIdMaquina() );
        rutinaMaquina.setIdRutina( rutinaMaquinaDTO.getIdRutina() );

        return rutinaMaquina;
    }

    @Override
    public RutinaMaquinaDTO toRutinaMaquinaDTO(RutinaMaquina rutinaMaquina) {
        if ( rutinaMaquina == null ) {
            return null;
        }

        RutinaMaquinaDTO rutinaMaquinaDTO = new RutinaMaquinaDTO();

        rutinaMaquinaDTO.setNombreRutina( rutinaMaquinaRutinaNombre( rutinaMaquina ) );
        rutinaMaquinaDTO.setNombreMaquina( rutinaMaquinaMaquinaNombre( rutinaMaquina ) );
        rutinaMaquinaDTO.setId( rutinaMaquina.getId() );
        rutinaMaquinaDTO.setIdMaquina( rutinaMaquina.getIdMaquina() );
        rutinaMaquinaDTO.setIdRutina( rutinaMaquina.getIdRutina() );

        return rutinaMaquinaDTO;
    }

    private String rutinaMaquinaRutinaNombre(RutinaMaquina rutinaMaquina) {
        if ( rutinaMaquina == null ) {
            return null;
        }
        Rutina rutina = rutinaMaquina.getRutina();
        if ( rutina == null ) {
            return null;
        }
        String nombre = rutina.getNombre();
        if ( nombre == null ) {
            return null;
        }
        return nombre;
    }

    private String rutinaMaquinaMaquinaNombre(RutinaMaquina rutinaMaquina) {
        if ( rutinaMaquina == null ) {
            return null;
        }
        Maquina maquina = rutinaMaquina.getMaquina();
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
