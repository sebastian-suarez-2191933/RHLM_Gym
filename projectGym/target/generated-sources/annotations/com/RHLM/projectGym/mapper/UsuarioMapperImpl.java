package com.RHLM.projectGym.mapper;

import com.RHLM.projectGym.dto.UsuarioDTO;
import com.RHLM.projectGym.model.Usuario;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-09T00:43:04-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.10 (Amazon.com Inc.)"
)
public class UsuarioMapperImpl implements UsuarioMapper {

    @Override
    public Usuario toUsario(UsuarioDTO usuarioDTO) {
        if ( usuarioDTO == null ) {
            return null;
        }

        Usuario usuario = new Usuario();

        usuario.setId( usuarioDTO.getId() );
        usuario.setIdPersona( usuarioDTO.getIdPersona() );
        usuario.setIdSuscripcion( usuarioDTO.getIdSuscripcion() );
        usuario.setPeso( usuarioDTO.getPeso() );
        usuario.setEstatura( usuarioDTO.getEstatura() );
        usuario.setTipoCuerpo( usuarioDTO.getTipoCuerpo() );
        usuario.setPorcentajeGraso( usuarioDTO.getPorcentajeGraso() );
        usuario.setObjetivo( usuarioDTO.getObjetivo() );

        return usuario;
    }

    @Override
    public UsuarioDTO toUsuarioDTO(Usuario usuario) {
        if ( usuario == null ) {
            return null;
        }

        UsuarioDTO usuarioDTO = new UsuarioDTO();

        usuarioDTO.setId( usuario.getId() );
        usuarioDTO.setIdPersona( usuario.getIdPersona() );
        usuarioDTO.setIdSuscripcion( usuario.getIdSuscripcion() );
        usuarioDTO.setPeso( usuario.getPeso() );
        usuarioDTO.setEstatura( usuario.getEstatura() );
        usuarioDTO.setTipoCuerpo( usuario.getTipoCuerpo() );
        usuarioDTO.setPorcentajeGraso( usuario.getPorcentajeGraso() );
        usuarioDTO.setObjetivo( usuario.getObjetivo() );

        return usuarioDTO;
    }
}
