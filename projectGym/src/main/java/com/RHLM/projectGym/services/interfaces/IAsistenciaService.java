package com.RHLM.projectGym.services.interfaces;

import com.RHLM.projectGym.model.Asistencia;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IAsistenciaService {

    List<Asistencia> getAll();

    Asistencia getAsistenciaById(Long id);

    Asistencia createAsistencia(Asistencia asistencia);

    Asistencia updateAsistencia(Asistencia asistencia);

    void deleteAsistenciaById(Long id);

    Asistencia findByIdentificacion(int identificacion);

}
