package com.yasarplusback.YasarPlusBackend.repositories;

import com.yasarplusback.YasarPlusBackend.entities.YasarUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
@Repository
@Transactional(readOnly = true)
public interface UserRepository extends JpaRepository<YasarUser,Long> {
    Optional<YasarUser> findByEmail(String email);
    @Transactional
    @Modifying
    @Query("UPDATE YasarUser a " +
            "SET a.enabled = TRUE WHERE a.email = ?1")
    int enableUser(String email);
}
