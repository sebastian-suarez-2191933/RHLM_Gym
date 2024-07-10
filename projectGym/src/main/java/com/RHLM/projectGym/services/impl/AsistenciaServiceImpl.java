package com.RHLM.projectGym.services.impl;

import com.RHLM.projectGym.exception.DataNotFoundException;
import com.RHLM.projectGym.exception.SubscriptionInactiveUserException;
import com.RHLM.projectGym.exception.UserNoRegisteredException;
import com.RHLM.projectGym.model.Asistencia;
import com.RHLM.projectGym.model.Suscripcion;
import com.RHLM.projectGym.model.Usuario;
import com.RHLM.projectGym.repository.IAsistenciaRepository;
import com.RHLM.projectGym.repository.ISuscripcionRepository;
import com.RHLM.projectGym.repository.IUsuarioRepository;
import com.RHLM.projectGym.services.interfaces.IAsistenciaService;
import com.RHLM.projectGym.services.interfaces.ISuscripcionService;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class AsistenciaServiceImpl implements IAsistenciaService {

    @Autowired
    IAsistenciaRepository asistenciaRepository;

    @Autowired
    IUsuarioRepository usuarioRepository;

    @Autowired
    ISuscripcionRepository suscripcionRepository;

    @Autowired
    ISuscripcionService suscripcionService;

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
    public ResponseEntity<Map<String, Object>> createAsistencia(int identificacion) {
        Usuario usuario = this.usuarioRepository.findSubByIdentificacion(identificacion);

        if (usuario == null){
            throw new UserNoRegisteredException("El usuario con la identificación " + identificacion + " no está registrado en el gimnasio.");
        }

        ZonedDateTime fechaActualZoned = ZonedDateTime.now(ZoneId.of("America/Bogota"));

        // Convierte la fecha actual a un Instant en UTC para comparar con fechaFin
        Instant fechaActual = fechaActualZoned.toInstant();

        // Convierte la fecha de finalización a un Instant en UTC
        Date fechaFin = usuario.getSuscripcion().getFechaFin();
        Instant fechaFinInstant = fechaFin.toInstant();

        if (usuario.getSuscripcion().getFechaFin() == null || fechaFinInstant.isBefore(fechaActual)) {

            var sus = this.suscripcionRepository.findById(usuario.getIdSuscripcion()).orElseThrow(DataNotFoundException::new);
            sus.desactivar();
            var suscripcionBD = this.suscripcionRepository.save(sus);
            this.validacion(suscripcionBD);

        }

        Asistencia asistencia = new Asistencia();
        asistencia.setIdUsuario(usuario.getId());
        asistencia.setLlegada(new Date());
        var asistenciaBD = this.asistenciaRepository.save(asistencia);
        this.entityManager.refresh(asistenciaBD);

        // Calcular los días restantes
        long diasRestantes = ChronoUnit.DAYS.between(fechaActual, fechaFinInstant);

        // Crear respuesta personalizada
        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("asistencia", asistenciaBD);
        respuesta.put("diasRestantes", diasRestantes);

        return ResponseEntity.ok(respuesta); // Devolver la respuesta como JSON
    }

    private void validacion(Suscripcion suscrip){
        if (Boolean.FALSE.equals(suscrip.getEstado()))
            throw new SubscriptionInactiveUserException("Suscripción inactiva, renueve su suscripción.");
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
    public Long findIdUsuarioByIdentificacion(int identificacion) {
        return this.usuarioRepository.findIdUsuarioByIdentificacion(identificacion);
    }

    @Override
    public List<Asistencia> findAsistenciaByFecha(Date fechaLlegada){
        return this.asistenciaRepository.findAsistenciaByFecha(fechaLlegada);
    }

    @Override
    public List<Asistencia> findAsistenciaByDocument(int documento){
        return this.asistenciaRepository.findAsistenciaByDocument(documento);
    }





}
