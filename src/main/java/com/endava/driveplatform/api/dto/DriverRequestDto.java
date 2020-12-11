package com.endava.driveplatform.api.dto;

import lombok.Data;

@Data
public class DriverRequestDto {
    private String firstName;
    private String lastName;
    private String gender;
    private Integer age;
    private String driverLicenseId;
}
