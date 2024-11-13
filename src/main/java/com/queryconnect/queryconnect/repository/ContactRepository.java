package com.queryconnect.queryconnect.repository;

import com.queryconnect.queryconnect.domain.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {
}