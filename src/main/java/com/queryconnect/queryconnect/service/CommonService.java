package com.queryconnect.queryconnect.service;

import com.queryconnect.queryconnect.domain.Institute;
import com.queryconnect.queryconnect.repository.AddressRepository;
import com.queryconnect.queryconnect.repository.ContactRepository;
import com.queryconnect.queryconnect.repository.InstituteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommonService {

    @Autowired
    AddressRepository addressRepository;

    @Autowired
    InstituteRepository instituteRepository;

    @Autowired
    ContactRepository contactRepository;

    @Transactional
    public void saveInstitute(Institute inst)
    {
        // address
        addressRepository.save(inst.getContact().   getPermanentAddress());
        // contact
        contactRepository.save(inst.getContact());
        // institute
        instituteRepository.save(inst);
    }
}
