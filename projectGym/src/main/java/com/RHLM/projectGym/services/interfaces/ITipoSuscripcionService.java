package com.RHLM.projectGym.services.interfaces;

import com.RHLM.projectGym.dto.TipoSuscripcionDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ITipoSuscripcionService {

    List<TipoSuscripcionDTO> getAll();
    TipoSuscripcionDTO findById(Long id);
    TipoSuscripcionDTO createTipo(TipoSuscripcionDTO tipoSuscripcionDTO);
    TipoSuscripcionDTO updateTipo(Long id, TipoSuscripcionDTO tipoSuscripcionDTO);
    void deleteTipo(Long id);
}
