package com.RHLM.projectGym.services.impl;

import com.RHLM.projectGym.dto.UsuarioDTO;
import com.RHLM.projectGym.exception.DataNotFoundException;
import com.RHLM.projectGym.mapper.UsuarioMapper;
import com.RHLM.projectGym.model.Usuario;
import com.RHLM.projectGym.repository.IUsuarioRepository;
import com.RHLM.projectGym.services.interfaces.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class UsuarioImpl implements IUsuarioService {

    @Autowired
    private IUsuarioRepository usuarioRepository;

    @Override
    public List<UsuarioDTO> getAll() {
        List<Usuario> usuarioList = this.usuarioRepository.findAll();
        return usuarioList.stream().map(UsuarioMapper.INSTANCE::toUsuarioDTO).collect(Collectors.toList());
    }


    @Override
    public UsuarioDTO findById(Long id) {
        Usuario usuarioFound = this.usuarioRepository.findById(id).orElseThrow(DataNotFoundException::new);
        return UsuarioMapper.INSTANCE.toUsuarioDTO(usuarioFound);
    }

    @Override
    public UsuarioDTO createUsuario(UsuarioDTO usuarioDTO) {
        Usuario data = UsuarioMapper.INSTANCE.toUsario(usuarioDTO);
        Usuario usuario = this.usuarioRepository.save(data);
        return UsuarioMapper.INSTANCE.toUsuarioDTO(usuario);
    }

    @Override
    public UsuarioDTO updateUsuario(Long id, UsuarioDTO usuarioDTO) {
        Usuario usuario = this.usuarioRepository.findById(id).orElseThrow(DataNotFoundException::new);

        usuario.setIdPersona(usuarioDTO.getIdPersona());
        usuario.setIdSuscripcion(usuarioDTO.getIdSuscripcion());
        usuario.setPeso(usuarioDTO.getPeso());
        usuario.setEstatura(usuarioDTO.getEstatura());
        usuario.setTipoCuerpo(usuarioDTO.getTipoCuerpo());
        usuario.setPorcentajeGraso(usuarioDTO.getPorcentajeGraso());
        usuario.setObjetivo(usuarioDTO.getObjetivo());

        Usuario usuarioUptaded = this.usuarioRepository.save(usuario);
        return UsuarioMapper.INSTANCE.toUsuarioDTO(usuarioUptaded);
    }

    @Override
    public void deleteUsuario(Long id){
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(DataNotFoundException::new);
        this.usuarioRepository.deleteById(usuario.getId());
    }

}
