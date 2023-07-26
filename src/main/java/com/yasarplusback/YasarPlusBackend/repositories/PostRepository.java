package com.yasarplusback.YasarPlusBackend.repositories;

import com.yasarplusback.YasarPlusBackend.entities.ConfirmationToken;
import com.yasarplusback.YasarPlusBackend.entities.Post;
import com.yasarplusback.YasarPlusBackend.entities.YasarUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post,Long> {


}
