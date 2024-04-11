package com.RHLM.projectGym.services.interfaces;

import com.RHLM.projectGym.dto.UsuarioDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IUsuarioService {

    List<UsuarioDTO> getAll();

    UsuarioDTO findById(Long id);

    UsuarioDTO createUsuario(UsuarioDTO usuarioDTO);

    UsuarioDTO updateUsuario(Long id, UsuarioDTO usuarioDTO);

    void deleteUsuario(Long id);
}
