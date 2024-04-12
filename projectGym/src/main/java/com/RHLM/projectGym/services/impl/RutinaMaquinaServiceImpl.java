package com.RHLM.projectGym.services.impl;

import com.RHLM.projectGym.exception.DataNotFoundException;
import com.RHLM.projectGym.model.RutinaMaquina;
import com.RHLM.projectGym.repository.IRutinaMaquinaRepository;
import com.RHLM.projectGym.services.interfaces.IRutinaMaquinaService;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RutinaMaquinaServiceImpl implements IRutinaMaquinaService {

    @Autowired
    private IRutinaMaquinaRepository rutinaMaquinaRepository;

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<RutinaMaquina> getAll() {
        return this.rutinaMaquinaRepository.findAll();
    }

    @Override
    public RutinaMaquina getRutinaMaquinaById(Long id) {
        return this.rutinaMaquinaRepository.findById(id).orElseThrow(DataNotFoundException::new);
    }

    @Override
    public RutinaMaquina createRutinaMaquina(RutinaMaquina rutinaMaquina) {
        var rutinaMaquinaBD= this.rutinaMaquinaRepository.save(rutinaMaquina);
        entityManager.refresh(rutinaMaquinaBD);
        return rutinaMaquinaBD;
    }

    @Override
    public RutinaMaquina updateRutinaMaquina(RutinaMaquina rutinaMaquina) {
        var rutinaMaquinaBD = this.rutinaMaquinaRepository.findById(rutinaMaquina.getId()).orElseThrow(DataNotFoundException::new);
        rutinaMaquinaBD.setIdRutina(rutinaMaquina.getIdRutina());
        rutinaMaquinaBD.setIdMaquina(rutinaMaquina.getIdMaquina());

        return this.rutinaMaquinaRepository.save(rutinaMaquinaBD);
    }

    @Override
    public void deleteRutinaMaquinaById(Long id) {
        var rutinaMaquinuaBD = this.rutinaMaquinaRepository.findById(id).orElseThrow(DataNotFoundException::new);
        this.rutinaMaquinaRepository.deleteById(rutinaMaquinuaBD.getId());

    }
}
