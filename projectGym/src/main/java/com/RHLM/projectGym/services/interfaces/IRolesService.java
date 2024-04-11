package com.RHLM.projectGym.services.interfaces;

import com.RHLM.projectGym.dto.RolesDTO;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface IRolesService {

    List<RolesDTO> getAll();

    RolesDTO findById(Long id);

    RolesDTO createRol(RolesDTO rolDTO);

    RolesDTO updateRol(Long id, RolesDTO rolesDTO);

    void deleteRol(Long id);

}
