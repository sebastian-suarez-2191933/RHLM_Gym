package com.RHLM.projectGym.mapper;

import com.RHLM.projectGym.dto.AdminDTO;
import com.RHLM.projectGym.model.Admin;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-09T00:43:04-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.10 (Amazon.com Inc.)"
)
public class AdminMapperImpl implements AdminMapper {

    @Override
    public Admin toAdmin(AdminDTO adminDTO) {
        if ( adminDTO == null ) {
            return null;
        }

        Admin admin = new Admin();

        admin.setId( adminDTO.getId() );
        admin.setIdPersona( adminDTO.getIdPersona() );
        admin.setUsuario( adminDTO.getUsuario() );
        admin.setContra( adminDTO.getContra() );
        admin.setCorreo( adminDTO.getCorreo() );

        return admin;
    }

    @Override
    public AdminDTO toAdminDTO(Admin admin) {
        if ( admin == null ) {
            return null;
        }

        AdminDTO adminDTO = new AdminDTO();

        adminDTO.setId( admin.getId() );
        adminDTO.setIdPersona( admin.getIdPersona() );
        adminDTO.setUsuario( admin.getUsuario() );
        adminDTO.setContra( admin.getContra() );
        adminDTO.setCorreo( admin.getCorreo() );

        return adminDTO;
    }
}
