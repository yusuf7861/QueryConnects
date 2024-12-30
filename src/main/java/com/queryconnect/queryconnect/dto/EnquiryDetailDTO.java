package com.queryconnect.queryconnect.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EnquiryDetailDTO {
    private Long enquiryId;
    private Date doe;
    private Date nextCallDate;
    private Float fees;
    private String remark;
    private String sourceOfEnquiry;
    private String name;
    private String phone;
    private String email;
    private String city;
    private String country;
    private String zip;
    private String detail;
    private String courses;
}
