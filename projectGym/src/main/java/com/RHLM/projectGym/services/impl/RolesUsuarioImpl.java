package com.RHLM.projectGym.services.impl;

import com.RHLM.projectGym.dto.RolesUsuarioDTO;
import com.RHLM.projectGym.exception.DataNotFoundException;
import com.RHLM.projectGym.mapper.RolesUsuarioMapper;
import com.RHLM.projectGym.model.RolesUsuario;
import com.RHLM.projectGym.repository.IRolesUsuarioRepository;
import com.RHLM.projectGym.services.interfaces.IRolesUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RolesUsuarioImpl implements IRolesUsuarioService {

    @Autowired
    private IRolesUsuarioRepository rolesUsuarioRepository;


    @Override
    public List<RolesUsuarioDTO> getAll() {
        List<RolesUsuario> rolesUsuario = this.rolesUsuarioRepository.findAll();
        return rolesUsuario.stream().map(RolesUsuarioMapper.INSTANCE::toRolesUsuarioDTO).collect(Collectors.toList());
    }


    @Override
    public RolesUsuarioDTO findById(Long id) {
        RolesUsuario rolesUsuarioFound = this.rolesUsuarioRepository.findById(id).orElseThrow(DataNotFoundException::new);
        return RolesUsuarioMapper.INSTANCE.toRolesUsuarioDTO(rolesUsuarioFound);
    }

    @Override
    public RolesUsuarioDTO createRolUsuario(RolesUsuarioDTO rolesUsuarioDTO) {
        RolesUsuario data = RolesUsuarioMapper.INSTANCE.toRolesUsuario(rolesUsuarioDTO);
        RolesUsuario rolesUsuario = this.rolesUsuarioRepository.save(data);
        return RolesUsuarioMapper.INSTANCE.toRolesUsuarioDTO(rolesUsuario);
    }

    @Override
    public RolesUsuarioDTO updateRolUsuario(Long id, RolesUsuarioDTO rolesUsuarioDTO) {
        RolesUsuario rolesUsuario = this.rolesUsuarioRepository.findById(id).orElseThrow(DataNotFoundException::new);

        rolesUsuario.setIdRol(rolesUsuarioDTO.getIdRol());
        rolesUsuario.setIdPersona(rolesUsuarioDTO.getIdPersona());
        rolesUsuario.setFechaDesde(rolesUsuarioDTO.getFechaDesde());
        rolesUsuario.setFechaHasta(rolesUsuarioDTO.getFechaHasta());

        RolesUsuario rolUsuarioUptaded = this.rolesUsuarioRepository.save(rolesUsuario);
        return RolesUsuarioMapper.INSTANCE.toRolesUsuarioDTO(rolUsuarioUptaded);
    }

    @Override
    public void deleteRolUsuario(Long id){
        RolesUsuario rol = rolesUsuarioRepository.findById(id).orElseThrow(DataNotFoundException::new);
        this.rolesUsuarioRepository.deleteById(rol.getId());
    }

}
