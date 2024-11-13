package com.queryconnect.queryconnect.repository;

import com.queryconnect.queryconnect.domain.Institute;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstituteRepository extends JpaRepository<Institute, Long> {
  }