package com.RHLM.projectGym.services.interfaces;

import com.RHLM.projectGym.model.Asistencia;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public interface IAsistenciaService {

    List<Asistencia> getAll();

    Asistencia getAsistenciaById(Long id);

    Asistencia createAsistencia(int identificacion);

    Asistencia updateAsistencia(Asistencia asistencia);

    void deleteAsistenciaById(Long id);

    Long findIdUsuarioByIdentificacion(int identificacion);

    List<Asistencia> findAsistenciaByFecha(Date fechaLlegada);
}
