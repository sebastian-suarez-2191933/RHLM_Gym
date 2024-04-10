package com.RHLM.projectGym.services.impl;

import com.RHLM.projectGym.exception.DataNotFoundException;
import com.RHLM.projectGym.model.Maquina;
import com.RHLM.projectGym.model.Musculo;
import com.RHLM.projectGym.repository.IMusculoRespository;
import com.RHLM.projectGym.services.interfaces.IMaquinaService;
import com.RHLM.projectGym.services.interfaces.IMusculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MusculoServiceImpl implements IMusculoService {

    @Autowired
    private IMusculoRespository musculoRespository;

    @Override
    public List<Musculo> getAll() {
        return this.musculoRespository.findAll();
    }

    @Override
    public Musculo findMusculoById(Long id) {
        return this.musculoRespository.findById(id).orElseThrow(DataNotFoundException::new);
    }

    @Override
    public Musculo createMusculo(Musculo musculo) {
        return this.musculoRespository.save(musculo);
    }

    @Override
    public Musculo updateMusculo(Musculo musculo) {
        var musculoBD = this.musculoRespository.findById(musculo.getId()).orElseThrow(DataNotFoundException::new);
        musculoBD.setNombre(musculo.getNombre());
        return this.musculoRespository.save(musculoBD);
    }

    @Override
    public void deleteMusculoById(Long id) {
        var musculoBD = this.musculoRespository.findById(id).orElseThrow(DataNotFoundException::new);
        this.musculoRespository.deleteById(musculoBD.getId());

    }
}
