package com.RHLM.projectGym.mapper;

import com.RHLM.projectGym.dto.MusculoDTO;
import com.RHLM.projectGym.model.Musculo;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-16T22:34:08-0500",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.38.0.v20240325-1403, environment: Java 17.0.10 (Eclipse Adoptium)"
)
public class MusculoMapperImpl implements MusculoMapper {

    @Override
    public Musculo toMusculo(MusculoDTO musculoDTO) {
        if ( musculoDTO == null ) {
            return null;
        }

        Musculo musculo = new Musculo();

        musculo.setId( musculoDTO.getId() );
        musculo.setNombre( musculoDTO.getNombre() );

        return musculo;
    }

    @Override
    public MusculoDTO toMusculoDTO(Musculo musculo) {
        if ( musculo == null ) {
            return null;
        }

        MusculoDTO musculoDTO = new MusculoDTO();

        musculoDTO.setId( musculo.getId() );
        musculoDTO.setNombre( musculo.getNombre() );

        return musculoDTO;
    }
}
