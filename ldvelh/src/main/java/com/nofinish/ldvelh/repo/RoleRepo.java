package com.nofinish.ldvelh.repo;

import com.nofinish.ldvelh.model.EnumRole;
import com.nofinish.ldvelh.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepo extends JpaRepository<Role, Long> {
    Optional<Role> findByName(EnumRole name);
}
