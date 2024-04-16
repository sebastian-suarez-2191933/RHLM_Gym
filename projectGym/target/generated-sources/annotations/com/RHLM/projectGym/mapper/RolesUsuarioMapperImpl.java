package com.RHLM.projectGym.mapper;

import com.RHLM.projectGym.dto.RolesUsuarioDTO;
import com.RHLM.projectGym.model.RolesUsuario;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-16T15:14:29-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.10 (Amazon.com Inc.)"
)
public class RolesUsuarioMapperImpl implements RolesUsuarioMapper {

    @Override
    public RolesUsuario toRolesUsuario(RolesUsuarioDTO rolesUsuarioDTO) {
        if ( rolesUsuarioDTO == null ) {
            return null;
        }

        RolesUsuario rolesUsuario = new RolesUsuario();

        rolesUsuario.setId( rolesUsuarioDTO.getId() );
        rolesUsuario.setIdRol( rolesUsuarioDTO.getIdRol() );
        rolesUsuario.setIdPersona( rolesUsuarioDTO.getIdPersona() );
        rolesUsuario.setFechaDesde( rolesUsuarioDTO.getFechaDesde() );
        rolesUsuario.setFechaHasta( rolesUsuarioDTO.getFechaHasta() );

        return rolesUsuario;
    }

    @Override
    public RolesUsuarioDTO toRolesUsuarioDTO(RolesUsuario rolesUsuario) {
        if ( rolesUsuario == null ) {
            return null;
        }

        RolesUsuarioDTO rolesUsuarioDTO = new RolesUsuarioDTO();

        rolesUsuarioDTO.setId( rolesUsuario.getId() );
        rolesUsuarioDTO.setIdRol( rolesUsuario.getIdRol() );
        rolesUsuarioDTO.setIdPersona( rolesUsuario.getIdPersona() );
        rolesUsuarioDTO.setFechaDesde( rolesUsuario.getFechaDesde() );
        rolesUsuarioDTO.setFechaHasta( rolesUsuario.getFechaHasta() );

        return rolesUsuarioDTO;
    }
}
