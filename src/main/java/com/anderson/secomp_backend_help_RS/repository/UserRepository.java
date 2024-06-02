package com.anderson.secomp_backend_help_RS.repository;

import com.anderson.secomp_backend_help_RS.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
