package com.RHLM.projectGym.services.impl;

import com.RHLM.projectGym.dto.TipoSuscripcionDTO;
import com.RHLM.projectGym.exception.DataNotFoundException;
import com.RHLM.projectGym.mapper.TipoSuscripcionMapper;
import com.RHLM.projectGym.model.TipoSuscripcion;
import com.RHLM.projectGym.repository.ITipoSuscripcionRepository;
import com.RHLM.projectGym.services.interfaces.ITipoSuscripcionService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class TipoSuscripcionImpl implements ITipoSuscripcionService {

    @Autowired
    private ITipoSuscripcionRepository tipoSuscripcionRepository;

    @Override
    public List<TipoSuscripcionDTO> getAll() {
        List<TipoSuscripcion> tiposList = this.tipoSuscripcionRepository.findAll();
        return tiposList.stream().map(TipoSuscripcionMapper.INSTANCE::toTipoSuscripcionDTO).collect(Collectors.toList());
    }

    @Override
    public TipoSuscripcionDTO findById(Long id) {
        TipoSuscripcion tipoSuscripcionFound = this.tipoSuscripcionRepository.findById(id).orElseThrow(DataNotFoundException::new);
        return TipoSuscripcionMapper.INSTANCE.toTipoSuscripcionDTO(tipoSuscripcionFound);
    }

    @Override
    public TipoSuscripcionDTO createTipo(TipoSuscripcionDTO tipoSuscripcionDTO) {
        TipoSuscripcion data = TipoSuscripcionMapper.INSTANCE.toTipoSuscripcion(tipoSuscripcionDTO);
        TipoSuscripcion tipo = this.tipoSuscripcionRepository.save(data);
        return TipoSuscripcionMapper.INSTANCE.toTipoSuscripcionDTO(tipo);
    }

    @Override
    public TipoSuscripcionDTO updateTipo(Long id, TipoSuscripcionDTO tipoSuscripcionDTO) {
        TipoSuscripcion tipoSuscripcion = this.tipoSuscripcionRepository.findById(id).orElseThrow(DataNotFoundException::new);

        tipoSuscripcion.setNombre(tipoSuscripcionDTO.getNombre());
        tipoSuscripcion.setPrecio(tipoSuscripcionDTO.getPrecio());
        tipoSuscripcion.setTiempo(tipoSuscripcionDTO.getTiempo());

        TipoSuscripcion tipoUpdated = this.tipoSuscripcionRepository.save(tipoSuscripcion);
        return TipoSuscripcionMapper.INSTANCE.toTipoSuscripcionDTO(tipoUpdated);
    }
    @Override
    public void deleteTipo(Long id){
        TipoSuscripcion tipoSuscripcion = tipoSuscripcionRepository.findById(id).orElseThrow(DataNotFoundException::new);
        this.tipoSuscripcionRepository.deleteById(tipoSuscripcion.getId());
    }

}
