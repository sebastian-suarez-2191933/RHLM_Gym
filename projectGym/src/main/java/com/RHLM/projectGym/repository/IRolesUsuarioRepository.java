package com.RHLM.projectGym.repository;

import com.RHLM.projectGym.model.RolesUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRolesUsuarioRepository extends JpaRepository<RolesUsuario, Long> {

}
