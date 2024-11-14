package com.queryconnect.queryconnect.dto;

import com.queryconnect.queryconnect.domain.Enquiry;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnquiryCommand {
    Enquiry enquiry;
    Long[] courses;
}
