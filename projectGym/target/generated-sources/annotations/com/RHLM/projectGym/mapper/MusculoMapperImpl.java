package com.RHLM.projectGym.mapper;

import com.RHLM.projectGym.dto.MusculoDTO;
import com.RHLM.projectGym.model.Musculo;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-10T20:38:40-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.10 (Amazon.com Inc.)"
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
