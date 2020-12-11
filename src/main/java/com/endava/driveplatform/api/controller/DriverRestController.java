package com.endava.driveplatform.api.controller;

import com.endava.driveplatform.api.dto.DriverRequestDto;
import com.endava.driveplatform.model.Driver;
import com.endava.driveplatform.service.DriverService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/drivers")
@RequiredArgsConstructor
public class DriverRestController {
    private final DriverService driverService;

    @GetMapping()
    public String getAllDrivers(Model model){
        model.addAttribute("message","Hello Theo");
        model.addAttribute("drivers",driverService.getAllDrivers());
        return "index";
    }
//    public List<Driver> getAllDrivers(){
//        return driverService.getAllDrivers();
//    }
    @PostMapping
    public Driver createDriver(@RequestBody DriverRequestDto driverRequestDto){
        return driverService.save(driverRequestDto);
    }

    @PutMapping("/{id}")
    public Driver editDriver(@PathVariable("id") Long id,
                             @RequestBody DriverRequestDto driverRequestDto){
        return driverService.update(id,driverRequestDto);
    }

    @DeleteMapping("/{id}")
    public String deleteDriver(@PathVariable("id") Long id){
        return driverService.delete(id);
    }
}
