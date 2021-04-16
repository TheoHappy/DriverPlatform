package com.endava.driveplatform.api.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class DriverRequestDto {
    private String firstName;
    private String lastName;
    private String gender;
    private Integer age;
    private String driverLicenseId;

    public DriverRequestDto(String firstName, String lastName, String gender, Integer age, String driverLicenseId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
        this.driverLicenseId = driverLicenseId;
    }
}
