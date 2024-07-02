package com.RHLM.projectGym.repository;

import com.RHLM.projectGym.model.Asistencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface IAsistenciaRepository extends JpaRepository<Asistencia, Long> {

    @Query("SELECT a " +
            "from Asistencia a " +
            "WHERE a.llegada = :fechaLlegada")
    List<Asistencia> findAsistenciaByFecha(@Param("fechaLlegada") Date fechaLlegada);

}
