package com.RHLM.projectGym.mapper;

import com.RHLM.projectGym.dto.RolesDTO;
import com.RHLM.projectGym.model.Roles;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RolesMapper {

    RolesMapper INSTANCE = Mappers.getMapper(RolesMapper.class);

    //DTO to Entity
    Roles toRoles(RolesDTO rolesDTO);

    //Entity to DTO
    RolesDTO toRolesDTO(Roles roles);
}
