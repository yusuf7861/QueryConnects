package com.queryconnect.queryconnect.repository;

import com.queryconnect.queryconnect.domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}