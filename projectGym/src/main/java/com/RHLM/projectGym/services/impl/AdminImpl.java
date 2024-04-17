package com.RHLM.projectGym.services.impl;

import com.RHLM.projectGym.dto.AdminDTO;
import com.RHLM.projectGym.exception.DataNotFoundException;
import com.RHLM.projectGym.mapper.AdminMapper;
import com.RHLM.projectGym.model.Admin;
import com.RHLM.projectGym.repository.IAdminRepository;
import com.RHLM.projectGym.services.interfaces.IAdminService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class AdminImpl implements IAdminService {

    @Autowired
    private IAdminRepository adminRepository;

    @Override
    public List<AdminDTO> getAll() {
        List<Admin> admins = this.adminRepository.findAll();
        return admins.stream().map(AdminMapper.INSTANCE::toAdminDTO).collect(Collectors.toList());
    }


    @Override
    public AdminDTO findById(Long id) {
        Admin adminFound = this.adminRepository.findById(id).orElseThrow(DataNotFoundException::new);
        return AdminMapper.INSTANCE.toAdminDTO(adminFound);
    }

    @Override
    public AdminDTO createAdmin(AdminDTO adminDTO) {
        Admin data = AdminMapper.INSTANCE.toAdmin(adminDTO);
        Admin admin = this.adminRepository.save(data);
        return AdminMapper.INSTANCE.toAdminDTO(admin);
    }

    @Override
    public AdminDTO updateAdmin(Long id, AdminDTO adminDTO) {
        Admin admin = this.adminRepository.findById(id).orElseThrow(DataNotFoundException::new);

        admin.setIdPersona(adminDTO.getIdPersona());
        admin.setUsuario(admin.getUsuario());
        admin.setCorreo(admin.getCorreo());
        admin.setContra(adminDTO.getContra());

        Admin adminUptaded = this.adminRepository.save(admin);
        return AdminMapper.INSTANCE.toAdminDTO(adminUptaded);
    }

    @Override
    public void deleteAdmin(Long id){
        Admin admin = adminRepository.findById(id).orElseThrow(DataNotFoundException::new);
        this.adminRepository.deleteById(admin.getId());
    }

    @Override
    public AdminDTO findByUsuario(String usuario) {
        Admin adminFound = this.adminRepository.findByUsuario(usuario);
        if (adminFound == null) {
            throw new DataNotFoundException(); // Lanza una excepción si no se encuentra el administrador
        }
        return AdminMapper.INSTANCE.toAdminDTO(adminFound);
    }

}
