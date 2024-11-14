package com.queryconnect.queryconnect.repository;

import com.queryconnect.queryconnect.domain.Institute;
import com.queryconnect.queryconnect.dto.InstituteDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface InstituteRepository extends JpaRepository<Institute, Long> {

  @Query("SELECT i.instituteId AS instituteId, i.name AS name, i.contact.phone AS phone, i.contact.email AS email, i.contact.permanentAddress.city as city FROM Institute AS i")
  public List<InstituteDto> getInstList();
}