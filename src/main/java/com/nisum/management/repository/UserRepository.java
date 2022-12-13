package com.nisum.management.repository;

import com.nisum.management.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UserModel, UUID> {

    Boolean existsByEmail(String email);

    Optional<UserModel> findByEmail(String email);

    Optional<UserModel> findByEmailAndPassword(String email, String password);
}
