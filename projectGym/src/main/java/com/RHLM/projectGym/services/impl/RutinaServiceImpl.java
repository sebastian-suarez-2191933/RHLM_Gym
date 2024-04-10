package com.RHLM.projectGym.services.impl;

import com.RHLM.projectGym.exception.DataNotFoundException;
import com.RHLM.projectGym.model.Rutina;
import com.RHLM.projectGym.repository.IRutinaRepository;
import com.RHLM.projectGym.services.interfaces.IRutinaService;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class RutinaServiceImpl implements IRutinaService {

    @Autowired
    private IRutinaRepository rutinaRepository;

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Rutina> getAll() {
        return this.rutinaRepository.findAll();
    }

    @Override
    public Rutina findRutinaById(Long id) {
        return this.rutinaRepository.findById(id).orElseThrow(DataNotFoundException::new);
    }

    @Override
    public Rutina createRutina(Rutina rutina) {
        var rutinaBD = this.rutinaRepository.save(rutina);
        this.entityManager.refresh(rutinaBD);
        return rutinaBD;
    }

    @Override
    public Rutina updateRutina(Rutina rutina) {
        var rutinaBD = this.rutinaRepository.findById(rutina.getId()).orElseThrow(DataNotFoundException::new);
        rutinaBD.setNombre(rutina.getNombre());
        rutinaBD.setIdMaquina(rutina.getIdMaquina());
        rutinaBD.setDescripcion(rutina.getDescripcion());
        return this.rutinaRepository.save(rutinaBD); //PROBAR SI SIRVE O HACER EL COMPLEMENTO
    }

    @Override
    public void deleteRutinaById(Long id) {
        var rutinaBD = this.rutinaRepository.findById(id).orElseThrow(DataNotFoundException::new);
        this.rutinaRepository.deleteById(rutinaBD.getId());

    }
}
