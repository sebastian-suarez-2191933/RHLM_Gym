package com.RHLM.projectGym.mapper;

import com.RHLM.projectGym.dto.RolesUsuarioDTO;
import com.RHLM.projectGym.model.RolesUsuario;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RolesUsuarioMapper {

    RolesUsuarioMapper INSTANCE = Mappers.getMapper(RolesUsuarioMapper.class);

    //DTO to Entity
    RolesUsuario toRolesUsuario(RolesUsuarioDTO rolesUsuarioDTO);

    //Entity to DTO
    RolesUsuarioDTO toRolesUsuarioDTO(RolesUsuario rolesUsuario);
}
