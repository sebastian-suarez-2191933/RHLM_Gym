package com.RHLM.projectGym.services.interfaces;

import com.RHLM.projectGym.model.Musculo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IMusculoService {
    List<Musculo> getAll();

    Musculo findMusculoById(Long id);

    Musculo createMusculo(Musculo musculo);

    Musculo updateMusculo(Musculo musculo);

    void deleteMusculoById(Long id);

}
