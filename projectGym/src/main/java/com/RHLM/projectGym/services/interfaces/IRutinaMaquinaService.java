package com.RHLM.projectGym.services.interfaces;

import com.RHLM.projectGym.model.RutinaMaquina;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IRutinaMaquinaService {

    List<RutinaMaquina> getAll();

    RutinaMaquina getRutinaMaquinaById(Long id);

    RutinaMaquina createRutinaMaquina(RutinaMaquina rutinaMaquina);

    RutinaMaquina updateRutinaMaquina(RutinaMaquina rutinaMaquina);

    void deleteRutinaMaquinaById(Long id);
}
