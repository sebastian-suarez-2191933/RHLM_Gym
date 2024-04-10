package com.RHLM.projectGym.services.impl;

import com.RHLM.projectGym.exception.DataNotFoundException;
import com.RHLM.projectGym.model.Maquina;
import com.RHLM.projectGym.model.Musculo;
import com.RHLM.projectGym.repository.IMaquinaRepository;
import com.RHLM.projectGym.services.interfaces.IMaquinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MaquinaServiceImpl implements IMaquinaService {

    @Autowired
    private IMaquinaRepository maquinaRepository;

    @Override
    public List<Maquina> getAll() {
        return this.maquinaRepository.findAll();
    }

    @Override
    public Maquina findMaquinaById(Long id) {
        return this.maquinaRepository.findById(id).orElseThrow(DataNotFoundException::new);
    }

    @Override
    public Maquina createMaquina(Maquina maquina) {
        return this.maquinaRepository.save(maquina);
    }

    @Override
    public Maquina updateMaquina(Maquina maquina) {
        var maquinaBD = this.maquinaRepository.findById(maquina.getId()).orElseThrow(DataNotFoundException::new);
        maquinaBD.setNombre(maquina.getNombre());
        return this.maquinaRepository.save(maquinaBD);
    }

    @Override
    public void deleteMaquinaById(Long id) {
        var maquinaBD = this.maquinaRepository.findById(id).orElseThrow(DataNotFoundException::new);
        this.maquinaRepository.deleteById(maquinaBD.getId());

    }

    @Autowired
    public void setMaquinaRepository(IMaquinaRepository maquinaRepository) {
        this.maquinaRepository = maquinaRepository;
    }
}
