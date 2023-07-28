package com.yasarplusback.YasarPlusBackend.repositories;

import com.yasarplusback.YasarPlusBackend.entities.UserComment;
import com.yasarplusback.YasarPlusBackend.entities.UserLike;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<UserLike,Long> {
}
