package com.RHLM.projectGym.services.interfaces;

import com.RHLM.projectGym.model.Rutina;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IRutinaService {
    List<Rutina> getAll();

    Rutina findRutinaById(Long id);

    Rutina createRutina(Rutina rutina);

    Rutina updateRutina(Rutina rutina);

    void deleteRutinaById(Long id);





}
