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
public class DriverController {
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

    @GetMapping("/addDriver")
    public String newDriver(Model model){
        model.addAttribute("driver", new Driver());
        return "addDriver";
    }

    @PostMapping
    public String createDriver(@ModelAttribute("driver") Driver driver, Model model){
        driverService.save(driver);
        return "redirect:/drivers";
    }
//    public Driver createDriver(@RequestBody DriverRequestDto driverRequestDto){
//        return driverService.save(driverRequestDto);
//    }

    @GetMapping("/updateDriver/{id}")
    public String updateDriver(@PathVariable (value = "id") long id, Model model){
        Driver driver = driverService.getDriverById(id);
        model.addAttribute("driver",driver);
        return "updateDriver";
    }
//    @PutMapping("/{id}")
//    public Driver editDriver(@PathVariable("id") Long id,
//                             @RequestBody DriverRequestDto driverRequestDto){
//        return driverService.update(id,driverRequestDto);
//    }

    @GetMapping("/deleteDriver/{id}")
    public String deleteDriver(@PathVariable (value = "id") long id){
        driverService.delete(id);
        return "redirect:/drivers";
    }
//    @DeleteMapping("/{id}")
//    public String deleteDriver(@PathVariable("id") Long id){
//         driverService.delete(id);
//         return "redirect/drivers";
//    }
}
