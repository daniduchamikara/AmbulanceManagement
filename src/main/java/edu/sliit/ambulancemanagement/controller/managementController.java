package edu.sliit.ambulancemanagement.controller;

import edu.sliit.ambulancemanagement.domain.dto.AmbulanceDto;
import edu.sliit.ambulancemanagement.domain.http.CommonJsonResponse;
import edu.sliit.ambulancemanagement.service.AmbulanceService;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/amb-manage-api")
public class managementController {

    AmbulanceService ambulanceService;

    public managementController(AmbulanceService ambulanceService) {
        this.ambulanceService = ambulanceService;
    }

    @PostMapping("/register-ambulance")
    public CommonJsonResponse registerCustomer(@RequestBody AmbulanceDto ambulanceDto){
        return ambulanceService.registerNewAmbulance(ambulanceDto);
    }

}
