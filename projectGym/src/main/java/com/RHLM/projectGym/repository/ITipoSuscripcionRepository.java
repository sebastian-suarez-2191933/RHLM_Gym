package com.RHLM.projectGym.repository;

import com.RHLM.projectGym.model.TipoSuscripcion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITipoSuscripcionRepository extends JpaRepository<TipoSuscripcion, Long> {
}
