package com.RHLM.projectGym.repository;

import com.RHLM.projectGym.model.Maquina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMaquinaRepository extends JpaRepository<Maquina, Long>{
}
