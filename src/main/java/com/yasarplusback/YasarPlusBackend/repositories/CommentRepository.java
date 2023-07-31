package com.yasarplusback.YasarPlusBackend.repositories;

import com.yasarplusback.YasarPlusBackend.entities.UserComment;
import com.yasarplusback.YasarPlusBackend.entities.YasarUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<UserComment,Long> {


}
