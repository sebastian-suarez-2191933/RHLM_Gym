package com.RHLM.projectGym.repository;

import com.RHLM.projectGym.model.Suscripcion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ISuscripcionRepository extends JpaRepository<Suscripcion, Long> {

}
