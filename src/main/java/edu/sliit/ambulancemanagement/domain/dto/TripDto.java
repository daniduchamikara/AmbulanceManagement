package edu.sliit.ambulancemanagement.domain.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TripDto {

    int tripId;
    int ambulanceId;
    String DriverName;
    String tripType;
    String createdDate;

    public TripDto(int tripId, int ambulanceId, String driverName, String tripType, String createdDate) {
        this.tripId = tripId;
        this.ambulanceId = ambulanceId;
        DriverName = driverName;
        this.tripType = tripType;
        this.createdDate = createdDate;
    }

    public TripDto() {
    }
}
