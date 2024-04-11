package com.RHLM.projectGym.repository;

import com.RHLM.projectGym.model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRolesRepository extends JpaRepository<Roles, Long> {
}
