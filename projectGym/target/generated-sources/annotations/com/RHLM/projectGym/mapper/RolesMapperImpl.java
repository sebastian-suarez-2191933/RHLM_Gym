package com.RHLM.projectGym.mapper;

import com.RHLM.projectGym.dto.RolesDTO;
import com.RHLM.projectGym.model.Roles;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-11T23:29:42-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.10 (Amazon.com Inc.)"
)
public class RolesMapperImpl implements RolesMapper {

    @Override
    public Roles toRoles(RolesDTO rolesDTO) {
        if ( rolesDTO == null ) {
            return null;
        }

        Roles roles = new Roles();

        roles.setId( rolesDTO.getId() );
        roles.setNombre( rolesDTO.getNombre() );
        roles.setFechaDesde( rolesDTO.getFechaDesde() );
        roles.setFechaHasta( rolesDTO.getFechaHasta() );

        return roles;
    }

    @Override
    public RolesDTO toRolesDTO(Roles roles) {
        if ( roles == null ) {
            return null;
        }

        RolesDTO rolesDTO = new RolesDTO();

        rolesDTO.setId( roles.getId() );
        rolesDTO.setNombre( roles.getNombre() );
        rolesDTO.setFechaDesde( roles.getFechaDesde() );
        rolesDTO.setFechaHasta( roles.getFechaHasta() );

        return rolesDTO;
    }
}
