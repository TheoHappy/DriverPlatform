package com.endava.driveplatform.service;

import com.endava.driveplatform.api.dto.DriverRequestDto;
import com.endava.driveplatform.model.Driver;
import com.endava.driveplatform.repository.DriverRepository;
import com.endava.driveplatform.utils.exceptions.DriverNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class DriverService {

    private final DriverRepository driverRepository;

    public List<Driver> getAllDrivers() {
        return new ArrayList<>(driverRepository.findAll());
    }

    public Driver getDriverById(Long id) {
        Driver driver = driverRepository.findById(id).orElseThrow(
                () -> new DriverNotFoundException("No such driver")
        );
        return driver;
    }

    public DriverRequestDto save(DriverRequestDto driverRequestDto) {
        Driver driver = mapDriverRequestDtoToDriver(driverRequestDto);
        driverRepository.save(driver);
        return driverRequestDto;
    }

    public void delete(Long id) {
        Driver driver = driverRepository.findById(id).orElseThrow(
                () -> new DriverNotFoundException("No such driver")
        );

        driverRepository.delete(driver);

    }

    private Driver mapDriverRequestDtoToDriver(DriverRequestDto driverRequestDto) {
        Driver driver = new Driver();

        driver.setFirstName(driverRequestDto.getFirstName());
        driver.setLastName(driverRequestDto.getLastName());
        driver.setAge(driverRequestDto.getAge());
        driver.setGender(driverRequestDto.getGender());
        driver.setDriverLicenseId(driverRequestDto.getDriverLicenseId());

        return driver;
    }

    public DriverRequestDto update(Long id, DriverRequestDto driverRequestDto) {
        Driver driver = driverRepository.findById(id).orElseThrow(
                () -> new DriverNotFoundException("No such driver")
        );

        driver.setFirstName(driverRequestDto.getFirstName());
        driver.setLastName(driverRequestDto.getLastName());
        driver.setAge(driverRequestDto.getAge());
        driver.setGender(driverRequestDto.getGender());
        driver.setDriverLicenseId(driverRequestDto.getDriverLicenseId());
        driverRepository.saveAndFlush(driver);
        return driverRequestDto;
    }


}
