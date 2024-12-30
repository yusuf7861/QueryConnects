package com.queryconnect.queryconnect.repository;

import com.queryconnect.queryconnect.domain.EnquirySource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnquirysourceRepository extends JpaRepository<EnquirySource, Long> {
}