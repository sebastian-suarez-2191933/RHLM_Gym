package com.RHLM.projectGym.mapper;

import com.RHLM.projectGym.dto.UsuarioDTO;
import com.RHLM.projectGym.model.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UsuarioMapper {

    UsuarioMapper INSTANCE = Mappers.getMapper(UsuarioMapper.class);

    //DTO to Entity
    Usuario toUsario(UsuarioDTO usuarioDTO);

    //Entity to DTO
    UsuarioDTO toUsuarioDTO(Usuario usuario);
}
