package com.RHLM.projectGym.services.interfaces;

import com.RHLM.projectGym.model.Maquina;
import com.RHLM.projectGym.model.Musculo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IMaquinaService {
    List<Maquina> getAll();
    Maquina findMaquinaById(Long id);

    Maquina createMaquina(Maquina maquina);

    Maquina updateMaquina (Maquina maquina);

    void deleteMaquinaById(Long id);

}
