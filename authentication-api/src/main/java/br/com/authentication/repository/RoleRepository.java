package br.com.authentication.repository;

import br.com.authentication.enums.ERole;
import br.com.authentication.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;


@Repository
public interface RoleRepository extends JpaRepository<Role, UUID> {
	Optional<Role> findByName(ERole name);
}
