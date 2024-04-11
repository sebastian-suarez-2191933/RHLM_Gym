package com.RHLM.projectGym.services.interfaces;

import com.RHLM.projectGym.dto.SuscripcionDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ISuscripcionService {


    List<SuscripcionDTO> getAll();
    SuscripcionDTO findById(Long id);
    SuscripcionDTO createSuscripcion(SuscripcionDTO suscripcionDTO);
    SuscripcionDTO updateSuscripcion(Long id, SuscripcionDTO suscripcionDTO);
    void deleteSuscripcion(Long id);
}
