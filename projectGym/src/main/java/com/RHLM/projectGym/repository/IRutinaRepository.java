package com.RHLM.projectGym.repository;

import com.RHLM.projectGym.model.Rutina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRutinaRepository extends JpaRepository<Rutina, Long> {
}
