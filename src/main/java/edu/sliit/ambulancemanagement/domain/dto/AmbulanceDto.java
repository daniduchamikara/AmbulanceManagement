package edu.sliit.ambulancemanagement.domain.dto;

import lombok.Data;

@Data
public class AmbulanceDto {
    int ambulanceId;
    String licensePlate;
    String vehicleModel;
    String other;
}
