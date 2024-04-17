package com.RHLM.projectGym.mapper;

import com.RHLM.projectGym.dto.RolesDTO;
import com.RHLM.projectGym.model.Roles;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-16T22:34:08-0500",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.38.0.v20240325-1403, environment: Java 17.0.10 (Eclipse Adoptium)"
)
public class RolesMapperImpl implements RolesMapper {

    @Override
    public Roles toRoles(RolesDTO rolesDTO) {
        if ( rolesDTO == null ) {
            return null;
        }

        Roles roles = new Roles();

        roles.setFechaDesde( rolesDTO.getFechaDesde() );
        roles.setFechaHasta( rolesDTO.getFechaHasta() );
        roles.setId( rolesDTO.getId() );
        roles.setNombre( rolesDTO.getNombre() );

        return roles;
    }

    @Override
    public RolesDTO toRolesDTO(Roles roles) {
        if ( roles == null ) {
            return null;
        }

        RolesDTO rolesDTO = new RolesDTO();

        rolesDTO.setFechaDesde( roles.getFechaDesde() );
        rolesDTO.setFechaHasta( roles.getFechaHasta() );
        rolesDTO.setId( roles.getId() );
        rolesDTO.setNombre( roles.getNombre() );

        return rolesDTO;
    }
}
