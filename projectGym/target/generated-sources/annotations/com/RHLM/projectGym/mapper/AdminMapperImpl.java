package com.RHLM.projectGym.mapper;

import com.RHLM.projectGym.dto.AdminDTO;
import com.RHLM.projectGym.model.Admin;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-16T22:34:08-0500",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.38.0.v20240325-1403, environment: Java 17.0.10 (Eclipse Adoptium)"
)
public class AdminMapperImpl implements AdminMapper {

    @Override
    public Admin toAdmin(AdminDTO adminDTO) {
        if ( adminDTO == null ) {
            return null;
        }

        Admin admin = new Admin();

        admin.setContra( adminDTO.getContra() );
        admin.setCorreo( adminDTO.getCorreo() );
        admin.setId( adminDTO.getId() );
        admin.setIdPersona( adminDTO.getIdPersona() );
        admin.setUsuario( adminDTO.getUsuario() );

        return admin;
    }

    @Override
    public AdminDTO toAdminDTO(Admin admin) {
        if ( admin == null ) {
            return null;
        }

        AdminDTO adminDTO = new AdminDTO();

        adminDTO.setContra( admin.getContra() );
        adminDTO.setCorreo( admin.getCorreo() );
        adminDTO.setId( admin.getId() );
        adminDTO.setIdPersona( admin.getIdPersona() );
        adminDTO.setUsuario( admin.getUsuario() );

        return adminDTO;
    }
}
