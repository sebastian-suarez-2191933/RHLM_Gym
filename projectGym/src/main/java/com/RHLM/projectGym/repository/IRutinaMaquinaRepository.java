package com.RHLM.projectGym.repository;

import com.RHLM.projectGym.model.RutinaMaquina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRutinaMaquinaRepository extends JpaRepository<RutinaMaquina, Long> {
}
