package com.RHLM.projectGym.services.impl;

import com.RHLM.projectGym.exception.DataNotFoundException;
import com.RHLM.projectGym.model.Asistencia;
import com.RHLM.projectGym.repository.IAsistenciaRepository;
import com.RHLM.projectGym.services.interfaces.IAsistenciaService;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AsistenciaServiceImpl implements IAsistenciaService {

    @Autowired
    IAsistenciaRepository asistenciaRepository;

    @Autowired
    EntityManager entityManager;

    @Override
    public List<Asistencia> getAll() {
        return this.asistenciaRepository.findAll();
    }

    @Override
    public Asistencia getAsistenciaById(Long id) {
        return this.asistenciaRepository.findById(id).orElseThrow(DataNotFoundException::new);
    }

    @Override
    public Asistencia createAsistencia(Asistencia asistencia) {
        var asistenciaBD = this.asistenciaRepository.save(asistencia);
        entityManager.refresh(asistenciaBD);
        return asistenciaBD;
    }

    @Override
    public Asistencia updateAsistencia(Asistencia asistencia) {
        var asistenciaBD = this.asistenciaRepository.findById(asistencia.getId()).orElseThrow(DataNotFoundException::new);
        asistenciaBD.setIdUsuario(asistencia.getIdUsuario());
        asistenciaBD.setIdRutina(asistencia.getIdRutina());
        asistenciaBD.setLlegada(asistencia.getLlegada());
        asistenciaBD.setSalida(asistencia.getSalida());

        return this.asistenciaRepository.save(asistenciaBD);
    }

    @Override
    public void deleteAsistenciaById(Long id) {
        var asistenciaBD = this.asistenciaRepository.findById(id).orElseThrow(DataNotFoundException::new);
        this.asistenciaRepository.deleteById(asistenciaBD.getId());

    }

    @Override
    public Asistencia findByIdentificacion(int identificacion) {
        return this.asistenciaRepository.findByIdentificacion(identificacion);
    }
}
