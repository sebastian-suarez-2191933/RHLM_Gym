package com.RHLM.projectGym.services.interfaces;

import com.RHLM.projectGym.model.MaquinaMusculo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IMaquinaMusculoService {

    List<MaquinaMusculo> getAll();

    MaquinaMusculo findMaquinaMusculoById(Long id);

    MaquinaMusculo createMaquinaMusculo(MaquinaMusculo maquinaMusculo);

    MaquinaMusculo updateMaquinaMusculo(MaquinaMusculo maquinaMusculo);

    void deleteMaquinaMusculoById(Long id);

}
