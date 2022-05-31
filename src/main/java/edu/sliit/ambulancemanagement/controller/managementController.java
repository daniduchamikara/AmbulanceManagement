package edu.sliit.ambulancemanagement.controller;

import edu.sliit.ambulancemanagement.domain.dto.AmbulanceDto;
import edu.sliit.ambulancemanagement.domain.dto.TripDto;
import edu.sliit.ambulancemanagement.domain.http.CommonJsonResponse;
import edu.sliit.ambulancemanagement.service.AmbulanceService;
import edu.sliit.ambulancemanagement.service.TripService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class managementController {

    AmbulanceService ambulanceService;
    TripService tripService;

    public managementController(AmbulanceService ambulanceService, TripService tripService) {
        this.ambulanceService = ambulanceService;
        this.tripService = tripService;
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

    @GetMapping("/view-all-trips")
    public List<TripDto> viewAllAmbulanceTrips(){
        return tripService.getAllTripDetails();
    }

    @GetMapping("/view-all-trips/{driverName}")
    public List<TripDto> viewAllAmbulanceTripsByDriverAndDate(@PathVariable("driverName") String driverName){
        return tripService.getTripDetailsByDate(driverName);
    }

    @GetMapping("/update-status/{key}/{id}/{dName}/{tripType}")
    public CommonJsonResponse updateAmulanceStatus(@PathVariable("key") String key,@PathVariable("id") String id,@PathVariable("dName") String dName,@PathVariable("tripType") String tripType){
        return ambulanceService.updateAmbulanceStatus(id,key,dName,tripType);
    }

}
