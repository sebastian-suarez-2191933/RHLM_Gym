package com.RHLM.projectGym.mapper;

import com.RHLM.projectGym.dto.RolesUsuarioDTO;
import com.RHLM.projectGym.model.RolesUsuario;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-16T22:34:08-0500",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.38.0.v20240325-1403, environment: Java 17.0.10 (Eclipse Adoptium)"
)
public class RolesUsuarioMapperImpl implements RolesUsuarioMapper {

    @Override
    public RolesUsuario toRolesUsuario(RolesUsuarioDTO rolesUsuarioDTO) {
        if ( rolesUsuarioDTO == null ) {
            return null;
        }

        RolesUsuario rolesUsuario = new RolesUsuario();

        rolesUsuario.setFechaDesde( rolesUsuarioDTO.getFechaDesde() );
        rolesUsuario.setFechaHasta( rolesUsuarioDTO.getFechaHasta() );
        rolesUsuario.setId( rolesUsuarioDTO.getId() );
        rolesUsuario.setIdPersona( rolesUsuarioDTO.getIdPersona() );
        rolesUsuario.setIdRol( rolesUsuarioDTO.getIdRol() );

        return rolesUsuario;
    }

    @Override
    public RolesUsuarioDTO toRolesUsuarioDTO(RolesUsuario rolesUsuario) {
        if ( rolesUsuario == null ) {
            return null;
        }

        RolesUsuarioDTO rolesUsuarioDTO = new RolesUsuarioDTO();

        rolesUsuarioDTO.setFechaDesde( rolesUsuario.getFechaDesde() );
        rolesUsuarioDTO.setFechaHasta( rolesUsuario.getFechaHasta() );
        rolesUsuarioDTO.setId( rolesUsuario.getId() );
        rolesUsuarioDTO.setIdPersona( rolesUsuario.getIdPersona() );
        rolesUsuarioDTO.setIdRol( rolesUsuario.getIdRol() );

        return rolesUsuarioDTO;
    }
}
