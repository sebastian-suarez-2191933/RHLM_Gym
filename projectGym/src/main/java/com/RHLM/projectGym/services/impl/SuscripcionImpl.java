package com.RHLM.projectGym.services.impl;

import com.RHLM.projectGym.dto.SuscripcionDTO;
import com.RHLM.projectGym.dto.TipoSuscripcionDTO;
import com.RHLM.projectGym.exception.DataNotFoundException;
import com.RHLM.projectGym.mapper.SuscripcionMapper;
import com.RHLM.projectGym.mapper.TipoSuscripcionMapper;
import com.RHLM.projectGym.model.Suscripcion;
import com.RHLM.projectGym.model.TipoSuscripcion;
import com.RHLM.projectGym.repository.ISuscripcionRepository;
import com.RHLM.projectGym.services.interfaces.ISuscripcionService;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class SuscripcionImpl implements ISuscripcionService {

    @Autowired
    private ISuscripcionRepository suscripcionRepository;

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<SuscripcionDTO> getAll() {
        List<Suscripcion> suscripcionList = this.suscripcionRepository.findAll();
        return suscripcionList.stream().map(SuscripcionMapper.INSTANCE::toSuscripcionDTO).collect(Collectors.toList());
    }

    @Override
    public SuscripcionDTO findById(Long id) {
        Suscripcion suscripcionFound = this.suscripcionRepository.findById(id).orElseThrow(DataNotFoundException::new);
        return SuscripcionMapper.INSTANCE.toSuscripcionDTO(suscripcionFound);
    }

    @Override
    public SuscripcionDTO createSuscripcion(SuscripcionDTO suscripcionDTO) {
        Suscripcion data = SuscripcionMapper.INSTANCE.toSuscripcion(suscripcionDTO);
        Suscripcion suscripcion = this.suscripcionRepository.save(data);
        return SuscripcionMapper.INSTANCE.toSuscripcionDTO(suscripcion);
    }

    @Override
    public SuscripcionDTO updateSuscripcion(Long id, SuscripcionDTO suscripcionDTO) {
        Suscripcion suscripcion = this.suscripcionRepository.findById(id).orElseThrow(DataNotFoundException::new);

        suscripcion.setIdTipoSuscripcion(suscripcionDTO.getIdTipoSuscripcion());
        suscripcion.setFechaInicio(suscripcionDTO.getFechaInicio());
        suscripcion.setFechaFin(suscripcionDTO.getFechaFin());
        suscripcion.setEstado(suscripcionDTO.getEstado());

        Suscripcion suscripcionUpdated = this.suscripcionRepository.save(suscripcion);
        return SuscripcionMapper.INSTANCE.toSuscripcionDTO(suscripcionUpdated);

    }
    @Override
    public void deleteSuscripcion(Long id){
        Suscripcion suscripcion = suscripcionRepository.findById(id).orElseThrow(DataNotFoundException::new);
        this.suscripcionRepository.deleteById(suscripcion.getId());
    }
}
