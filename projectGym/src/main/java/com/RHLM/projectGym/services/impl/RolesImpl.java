package com.RHLM.projectGym.services.impl;

import com.RHLM.projectGym.dto.RolesDTO;
import com.RHLM.projectGym.exception.DataNotFoundException;
import com.RHLM.projectGym.mapper.RolesMapper;
import com.RHLM.projectGym.model.Roles;
import com.RHLM.projectGym.repository.IRolesRepository;
import com.RHLM.projectGym.services.interfaces.IRolesService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Transactional
@Service
public class RolesImpl implements IRolesService {


    @Autowired
    private IRolesRepository rolesRepository;

    @Override
    public List<RolesDTO> getAll() {
        List<Roles> rolesList = this.rolesRepository.findAll();
        return rolesList.stream().map(RolesMapper.INSTANCE::toRolesDTO).collect(Collectors.toList());
    }


    @Override
    public RolesDTO findById(Long id) {
        Roles rolesFound = this.rolesRepository.findById(id).orElseThrow(DataNotFoundException::new);
        return RolesMapper.INSTANCE.toRolesDTO(rolesFound);
    }

    @Override
    public RolesDTO createRol(RolesDTO rolDTO) {
        Roles data = RolesMapper.INSTANCE.toRoles(rolDTO);
        Roles roles = this.rolesRepository.save(data);
        return RolesMapper.INSTANCE.toRolesDTO(roles);
    }

    @Override
    public RolesDTO updateRol(Long id, RolesDTO rolDTO) {
        Roles rol = this.rolesRepository.findById(id).orElseThrow(DataNotFoundException::new);

        rol.setNombre(rolDTO.getNombre());
        rol.setFechaDesde(rolDTO.getFechaDesde());
        rol.setFechaHasta(rolDTO.getFechaHasta());

        Roles rolUptaded = this.rolesRepository.save(rol);
        return RolesMapper.INSTANCE.toRolesDTO(rolUptaded);
    }

    @Override
    public void deleteRol(Long id){
        Roles rol = rolesRepository.findById(id).orElseThrow(DataNotFoundException::new);
        this.rolesRepository.deleteById(rol.getId());
    }

}
