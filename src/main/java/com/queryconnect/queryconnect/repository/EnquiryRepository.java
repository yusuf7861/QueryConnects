package com.queryconnect.queryconnect.repository;

import com.queryconnect.queryconnect.domain.Enquiry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnquiryRepository extends JpaRepository<Enquiry, Long> {
}