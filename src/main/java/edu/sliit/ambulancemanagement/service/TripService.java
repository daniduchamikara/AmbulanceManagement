package edu.sliit.ambulancemanagement.service;

import edu.sliit.ambulancemanagement.domain.dto.TripDto;

import java.util.List;

public interface TripService {

    public List<TripDto> getAllTripDetails();
    public List<TripDto> getTripDetailsByDate(String fromDate);
}
