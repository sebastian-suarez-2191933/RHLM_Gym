package com.RHLM.projectGym.mapper;

import com.RHLM.projectGym.dto.AsistenciaDTO;
import com.RHLM.projectGym.model.Asistencia;
import com.RHLM.projectGym.model.Persona;
import com.RHLM.projectGym.model.Rutina;
import com.RHLM.projectGym.model.Suscripcion;
import com.RHLM.projectGym.model.TipoSuscripcion;
import com.RHLM.projectGym.model.Usuario;
import java.util.Date;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-09T00:43:04-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.10 (Amazon.com Inc.)"
)
public class AsistenciaMapperImpl implements AsistenciaMapper {

    @Override
    public Asistencia toAsistencia(AsistenciaDTO asistenciaDTO) {
        if ( asistenciaDTO == null ) {
            return null;
        }

        Asistencia asistencia = new Asistencia();

        asistencia.setId( asistenciaDTO.getId() );
        asistencia.setIdUsuario( asistenciaDTO.getIdUsuario() );
        asistencia.setIdRutina( asistenciaDTO.getIdRutina() );
        asistencia.setLlegada( asistenciaDTO.getLlegada() );
        asistencia.setSalida( asistenciaDTO.getSalida() );

        return asistencia;
    }

    @Override
    public AsistenciaDTO toAsistenciaDTO(Asistencia asistencia) {
        if ( asistencia == null ) {
            return null;
        }

        AsistenciaDTO asistenciaDTO = new AsistenciaDTO();

        asistenciaDTO.setNombreUsuario( asistenciaUsuarioPersonaNombre( asistencia ) );
        asistenciaDTO.setNombreRutina( asistenciaRutinaNombre( asistencia ) );
        asistenciaDTO.setFechaInicio( asistenciaUsuarioSuscripcionFechaInicio( asistencia ) );
        asistenciaDTO.setFechaFin( asistenciaUsuarioSuscripcionFechaFin( asistencia ) );
        asistenciaDTO.setEstado( asistenciaUsuarioSuscripcionEstado( asistencia ) );
        asistenciaDTO.setNombreSuscripcion( asistenciaUsuarioSuscripcionTipoSuscripcionNombre( asistencia ) );
        asistenciaDTO.setId( asistencia.getId() );
        asistenciaDTO.setIdUsuario( asistencia.getIdUsuario() );
        asistenciaDTO.setIdRutina( asistencia.getIdRutina() );
        asistenciaDTO.setLlegada( asistencia.getLlegada() );
        asistenciaDTO.setSalida( asistencia.getSalida() );

        return asistenciaDTO;
    }

    private String asistenciaUsuarioPersonaNombre(Asistencia asistencia) {
        if ( asistencia == null ) {
            return null;
        }
        Usuario usuario = asistencia.getUsuario();
        if ( usuario == null ) {
            return null;
        }
        Persona persona = usuario.getPersona();
        if ( persona == null ) {
            return null;
        }
        String nombre = persona.getNombre();
        if ( nombre == null ) {
            return null;
        }
        return nombre;
    }

    private String asistenciaRutinaNombre(Asistencia asistencia) {
        if ( asistencia == null ) {
            return null;
        }
        Rutina rutina = asistencia.getRutina();
        if ( rutina == null ) {
            return null;
        }
        String nombre = rutina.getNombre();
        if ( nombre == null ) {
            return null;
        }
        return nombre;
    }

    private Date asistenciaUsuarioSuscripcionFechaInicio(Asistencia asistencia) {
        if ( asistencia == null ) {
            return null;
        }
        Usuario usuario = asistencia.getUsuario();
        if ( usuario == null ) {
            return null;
        }
        Suscripcion suscripcion = usuario.getSuscripcion();
        if ( suscripcion == null ) {
            return null;
        }
        Date fechaInicio = suscripcion.getFechaInicio();
        if ( fechaInicio == null ) {
            return null;
        }
        return fechaInicio;
    }

    private Date asistenciaUsuarioSuscripcionFechaFin(Asistencia asistencia) {
        if ( asistencia == null ) {
            return null;
        }
        Usuario usuario = asistencia.getUsuario();
        if ( usuario == null ) {
            return null;
        }
        Suscripcion suscripcion = usuario.getSuscripcion();
        if ( suscripcion == null ) {
            return null;
        }
        Date fechaFin = suscripcion.getFechaFin();
        if ( fechaFin == null ) {
            return null;
        }
        return fechaFin;
    }

    private Boolean asistenciaUsuarioSuscripcionEstado(Asistencia asistencia) {
        if ( asistencia == null ) {
            return null;
        }
        Usuario usuario = asistencia.getUsuario();
        if ( usuario == null ) {
            return null;
        }
        Suscripcion suscripcion = usuario.getSuscripcion();
        if ( suscripcion == null ) {
            return null;
        }
        Boolean estado = suscripcion.getEstado();
        if ( estado == null ) {
            return null;
        }
        return estado;
    }

    private String asistenciaUsuarioSuscripcionTipoSuscripcionNombre(Asistencia asistencia) {
        if ( asistencia == null ) {
            return null;
        }
        Usuario usuario = asistencia.getUsuario();
        if ( usuario == null ) {
            return null;
        }
        Suscripcion suscripcion = usuario.getSuscripcion();
        if ( suscripcion == null ) {
            return null;
        }
        TipoSuscripcion tipoSuscripcion = suscripcion.getTipoSuscripcion();
        if ( tipoSuscripcion == null ) {
            return null;
        }
        String nombre = tipoSuscripcion.getNombre();
        if ( nombre == null ) {
            return null;
        }
        return nombre;
    }
}
