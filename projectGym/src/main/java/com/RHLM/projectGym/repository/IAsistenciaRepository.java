package com.RHLM.projectGym.repository;

import com.RHLM.projectGym.dto.AsistenciaDTO;
import com.RHLM.projectGym.model.Asistencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IAsistenciaRepository extends JpaRepository<Asistencia, Long> {

    @Query("SELECT a " +
            "from Asistencia a " +
            "WHERE (a.usuario.persona.identificacion = :identificacion )")
    Asistencia findByIdentificacion(int identificacion);
}
