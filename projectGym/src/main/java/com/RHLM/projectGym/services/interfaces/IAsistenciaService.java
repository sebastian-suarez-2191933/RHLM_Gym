package com.RHLM.projectGym.services.interfaces;

import com.RHLM.projectGym.model.Asistencia;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public interface IAsistenciaService {

    List<Asistencia> getAll();

    Asistencia getAsistenciaById(Long id);

    public ResponseEntity<Map<String, Object>> createAsistencia(int identificacion);

    Asistencia updateAsistencia(Asistencia asistencia);

    void deleteAsistenciaById(Long id);

    Long findIdUsuarioByIdentificacion(int identificacion);

    List<Asistencia> findAsistenciaByFecha(Date fechaLlegada);

    List<Asistencia> findAsistenciaByDocument(int documento);
}
