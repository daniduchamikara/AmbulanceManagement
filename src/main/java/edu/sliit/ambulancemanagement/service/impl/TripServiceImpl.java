package edu.sliit.ambulancemanagement.service.impl;

import edu.sliit.ambulancemanagement.domain.dto.TripDto;
import edu.sliit.ambulancemanagement.domain.http.CommonJsonResponse;
import edu.sliit.ambulancemanagement.domain.model.TripModel;
import edu.sliit.ambulancemanagement.repositary.TripRepo;
import edu.sliit.ambulancemanagement.service.TripService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
@Service
public class TripServiceImpl implements TripService {
    TripRepo tripRepo;

    public TripServiceImpl(TripRepo tripRepo) {
        this.tripRepo = tripRepo;
    }

    @Override
    public List<TripDto> getAllTripDetails() {
        List<TripDto> tripDtoList = new ArrayList<>();
        List<TripModel> tripModelList = tripRepo.findAll();
        for (TripModel tripModel:  tripModelList) {
            TripDto tripDto = new TripDto();
            tripDto.setTripId(tripModel.getTripId());
            tripDto.setAmbulanceId(tripModel.getAmbulanceId());
            tripDto.setTripType(tripModel.getTripType());
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String created_Date =tripModel.getCreatedDate().format(formatter);
            tripDto.setCreatedDate(created_Date);
            tripDto.setDriverName(tripModel.getDriverName());
            tripDtoList.add(tripDto);
        }

        return tripDtoList;
    }

    @Override
    public List<TripDto> getTripDetailsByDate(String driverName) {
        List<TripDto> tripDtoList = new ArrayList<>();
        List<TripModel> tripModelList = tripRepo.findByDriverName(driverName);
        for (TripModel tripModel:  tripModelList) {
            TripDto tripDto = new TripDto();
            tripDto.setTripId(tripModel.getTripId());
            tripDto.setAmbulanceId(tripModel.getAmbulanceId());
            tripDto.setTripType(tripModel.getTripType());
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String created_Date =tripModel.getCreatedDate().format(formatter);
            tripDto.setCreatedDate(created_Date);
            tripDto.setDriverName(tripModel.getDriverName());
            tripDtoList.add(tripDto);
        }

        return tripDtoList;
    }
}
