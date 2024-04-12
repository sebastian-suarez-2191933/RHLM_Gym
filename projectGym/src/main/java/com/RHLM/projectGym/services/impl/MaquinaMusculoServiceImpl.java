package com.RHLM.projectGym.services.impl;


import com.RHLM.projectGym.exception.DataNotFoundException;
import com.RHLM.projectGym.model.MaquinaMusculo;
import com.RHLM.projectGym.repository.IMaquinaMusculoRespository;
import com.RHLM.projectGym.services.interfaces.IMaquinaMusculoService;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MaquinaMusculoServiceImpl implements IMaquinaMusculoService {

    @Autowired
    private IMaquinaMusculoRespository maquinaMusculoRespository;

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<MaquinaMusculo> getAll() {
        return this.maquinaMusculoRespository.findAll();
    }

    @Override
    public MaquinaMusculo findMaquinaMusculoById(Long id) {
        return this.maquinaMusculoRespository.findById(id).orElseThrow(DataNotFoundException::new);
    }

    @Override
    public MaquinaMusculo createMaquinaMusculo(MaquinaMusculo maquinaMusculo) {
        var maquinaMusculoBD = this.maquinaMusculoRespository.save(maquinaMusculo);
        entityManager.refresh(maquinaMusculoBD);
        return maquinaMusculoBD;
    }

    @Override
    public MaquinaMusculo updateMaquinaMusculo(MaquinaMusculo maquinaMusculo) {
        var maquinaMusculoBD = this.maquinaMusculoRespository.findById(maquinaMusculo.getId()).orElseThrow(DataNotFoundException::new);
        maquinaMusculoBD.setIdMaquina(maquinaMusculo.getIdMaquina());
        maquinaMusculoBD.setIdMusculo(maquinaMusculo.getIdMusculo());

        return this.maquinaMusculoRespository.save(maquinaMusculoBD);
    }

    @Override
    public void deleteMaquinaMusculoById(Long id) {
        var maquinaMusculoBD = this.maquinaMusculoRespository.findById(id).orElseThrow(DataNotFoundException::new);
        this.maquinaMusculoRespository.deleteById(maquinaMusculoBD.getId());
    }
}
