package edu.sliit.ambulancemanagement.controller;

import edu.sliit.ambulancemanagement.domain.dto.AmbulanceDto;
import edu.sliit.ambulancemanagement.domain.http.CommonJsonResponse;
import edu.sliit.ambulancemanagement.service.AmbulanceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class managementController {

    AmbulanceService ambulanceService;

    public managementController(AmbulanceService ambulanceService) {
        this.ambulanceService = ambulanceService;
    }

    @PostMapping("/register-ambulance")
    public CommonJsonResponse registerAmbulance(@RequestBody AmbulanceDto ambulanceDto){
        return ambulanceService.registerNewAmbulance(ambulanceDto);
    }

    @PostMapping("/remove-ambulance")
    public CommonJsonResponse removeAmbulance(@RequestBody AmbulanceDto ambulanceDto){
        return ambulanceService.deleteAmbulance(ambulanceDto);
    }

    @PostMapping("/update-ambulance")
    public CommonJsonResponse updateAmbulance(@RequestBody AmbulanceDto ambulanceDto){
        return ambulanceService.updateAmbulance(ambulanceDto);
    }

    @GetMapping("/view-all")
    public List<AmbulanceDto> viewAllAmbulance(){
        return ambulanceService.viewAllAmbulance();
    }



}
