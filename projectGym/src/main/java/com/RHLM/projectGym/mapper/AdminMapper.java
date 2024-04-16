package com.RHLM.projectGym.mapper;

import com.RHLM.projectGym.dto.AdminDTO;
import com.RHLM.projectGym.model.Admin;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AdminMapper {

    AdminMapper INSTANCE = Mappers.getMapper(AdminMapper.class);

    //DTO to Entity
    Admin toAdmin(AdminDTO adminDTO);

    //Entity to DTO
    AdminDTO toAdminDTO(Admin admin);
}
