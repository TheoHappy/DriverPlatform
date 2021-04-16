package com.endava.driveplatform.api.controller;

import com.endava.driveplatform.api.dto.DriverRequestDto;
import com.endava.driveplatform.model.Driver;
import com.endava.driveplatform.service.DriverService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/drivers")
@RequiredArgsConstructor
public class DriverRestController {
    private final DriverService driverService;


    @GetMapping
    public List<Driver> getAllDrivers(){
        return driverService.getAllDrivers();
    }

    @GetMapping("/{id}")
    public Driver getDriver(@PathVariable("id") Long id){
        return driverService.getDriverById(id);
    }

    @PostMapping
    public DriverRequestDto createDriver(@RequestBody DriverRequestDto driverRequestDto){
        return driverService.save(driverRequestDto);
    }

    @PutMapping("/{id}")
    public DriverRequestDto editDriver(@PathVariable("id") Long id,
                             @RequestBody DriverRequestDto driverRequestDto){
        return driverService.update(id,driverRequestDto);
    }

    @DeleteMapping("/{id}")
    public void deleteDriver(@PathVariable("id") Long id){
         driverService.delete(id);
    }
}
