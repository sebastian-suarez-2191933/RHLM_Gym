package com.RHLM.projectGym.mapper;

import com.RHLM.projectGym.dto.UsuarioDTO;
import com.RHLM.projectGym.model.Usuario;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-16T22:34:08-0500",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.38.0.v20240325-1403, environment: Java 17.0.10 (Eclipse Adoptium)"
)
public class UsuarioMapperImpl implements UsuarioMapper {

    @Override
    public Usuario toUsario(UsuarioDTO usuarioDTO) {
        if ( usuarioDTO == null ) {
            return null;
        }

        Usuario usuario = new Usuario();

        usuario.setEstatura( usuarioDTO.getEstatura() );
        usuario.setId( usuarioDTO.getId() );
        usuario.setIdPersona( usuarioDTO.getIdPersona() );
        usuario.setIdSuscripcion( usuarioDTO.getIdSuscripcion() );
        usuario.setObjetivo( usuarioDTO.getObjetivo() );
        usuario.setPeso( usuarioDTO.getPeso() );
        usuario.setPorcentajeGraso( usuarioDTO.getPorcentajeGraso() );
        usuario.setTipoCuerpo( usuarioDTO.getTipoCuerpo() );

        return usuario;
    }

    @Override
    public UsuarioDTO toUsuarioDTO(Usuario usuario) {
        if ( usuario == null ) {
            return null;
        }

        UsuarioDTO usuarioDTO = new UsuarioDTO();

        usuarioDTO.setEstatura( usuario.getEstatura() );
        usuarioDTO.setId( usuario.getId() );
        usuarioDTO.setIdPersona( usuario.getIdPersona() );
        usuarioDTO.setIdSuscripcion( usuario.getIdSuscripcion() );
        usuarioDTO.setObjetivo( usuario.getObjetivo() );
        usuarioDTO.setPeso( usuario.getPeso() );
        usuarioDTO.setPorcentajeGraso( usuario.getPorcentajeGraso() );
        usuarioDTO.setTipoCuerpo( usuario.getTipoCuerpo() );

        return usuarioDTO;
    }
}
