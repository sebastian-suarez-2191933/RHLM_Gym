package com.RHLM.projectGym.services.interfaces;

import com.RHLM.projectGym.dto.AdminDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IAdminService {
    List<AdminDTO> getAll();

    AdminDTO findById(Long id);

    AdminDTO createAdmin(AdminDTO adminDTO);

    AdminDTO updateAdmin(Long id, AdminDTO adminDTO);

    void deleteAdmin(Long id);
}
