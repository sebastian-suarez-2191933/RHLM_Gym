package com.RHLM.projectGym.mapper;

import com.RHLM.projectGym.dto.MaquinaMusculoDTO;
import com.RHLM.projectGym.model.Maquina;
import com.RHLM.projectGym.model.MaquinaMusculo;
import com.RHLM.projectGym.model.Musculo;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-16T22:34:08-0500",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.38.0.v20240325-1403, environment: Java 17.0.10 (Eclipse Adoptium)"
)
public class MaquinaMusculoMapperImpl implements MaquinaMusculoMapper {

    @Override
    public MaquinaMusculo toMaquinaMusculo(MaquinaMusculoDTO maquinaMusculoDTO) {
        if ( maquinaMusculoDTO == null ) {
            return null;
        }

        MaquinaMusculo maquinaMusculo = new MaquinaMusculo();

        maquinaMusculo.setId( maquinaMusculoDTO.getId() );
        maquinaMusculo.setIdMaquina( maquinaMusculoDTO.getIdMaquina() );
        maquinaMusculo.setIdMusculo( maquinaMusculoDTO.getIdMusculo() );

        return maquinaMusculo;
    }

    @Override
    public MaquinaMusculoDTO toMaquinaMusculoDTO(MaquinaMusculo maquinaMusculo) {
        if ( maquinaMusculo == null ) {
            return null;
        }

        MaquinaMusculoDTO maquinaMusculoDTO = new MaquinaMusculoDTO();

        maquinaMusculoDTO.setNombreMaquina( maquinaMusculoMaquinaNombre( maquinaMusculo ) );
        maquinaMusculoDTO.setNombreMusculo( maquinaMusculoMusculoNombre( maquinaMusculo ) );
        maquinaMusculoDTO.setId( maquinaMusculo.getId() );
        maquinaMusculoDTO.setIdMaquina( maquinaMusculo.getIdMaquina() );
        maquinaMusculoDTO.setIdMusculo( maquinaMusculo.getIdMusculo() );

        return maquinaMusculoDTO;
    }

    private String maquinaMusculoMaquinaNombre(MaquinaMusculo maquinaMusculo) {
        if ( maquinaMusculo == null ) {
            return null;
        }
        Maquina maquina = maquinaMusculo.getMaquina();
        if ( maquina == null ) {
            return null;
        }
        String nombre = maquina.getNombre();
        if ( nombre == null ) {
            return null;
        }
        return nombre;
    }

    private String maquinaMusculoMusculoNombre(MaquinaMusculo maquinaMusculo) {
        if ( maquinaMusculo == null ) {
            return null;
        }
        Musculo musculo = maquinaMusculo.getMusculo();
        if ( musculo == null ) {
            return null;
        }
        String nombre = musculo.getNombre();
        if ( nombre == null ) {
            return null;
        }
        return nombre;
    }
}
