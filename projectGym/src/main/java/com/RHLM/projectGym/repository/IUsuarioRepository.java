package com.RHLM.projectGym.repository;

import com.RHLM.projectGym.model.Suscripcion;
import com.RHLM.projectGym.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Long> {

    @Query("SELECT u.id " +
            "FROM Usuario u " +
            "WHERE u.persona.identificacion = :identificacion")
    Long findIdUsuarioByIdentificacion(int identificacion);

    @Query("SELECT u " +
            "FROM Usuario u " +
            " WHERE u.persona.identificacion = :identificacion")
    Usuario findSubByIdentificacion(int identificacion);


}
