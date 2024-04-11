package com.RHLM.projectGym.services.interfaces;

import com.RHLM.projectGym.dto.RolesDTO;
import com.RHLM.projectGym.dto.RolesUsuarioDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IRolesUsuarioService {


    List<RolesUsuarioDTO> getAll();

    RolesUsuarioDTO findById(Long id);

    RolesUsuarioDTO createRolUsuario(RolesUsuarioDTO rolesUsuarioDTO);

    RolesUsuarioDTO updateRolUsuario(Long id, RolesUsuarioDTO rolesUsuarioDTO);

    void deleteRolUsuario(Long id);
}
