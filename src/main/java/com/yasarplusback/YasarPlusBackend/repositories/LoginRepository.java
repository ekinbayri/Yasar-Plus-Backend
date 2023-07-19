package com.yasarplusback.YasarPlusBackend.repositories;

import com.yasarplusback.YasarPlusBackend.entities.YasarUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LoginRepository extends JpaRepository<YasarUser,Long> {
    Optional<YasarUser> findOneByEmailAndPassword(String email, String password);
    YasarUser findByEmail(String email);
}
