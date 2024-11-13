package com.queryconnect.queryconnect.repository;

import com.queryconnect.queryconnect.domain.Followup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FollowupRepository extends JpaRepository<Followup, Long> {
}