package edu.sliit.ambulancemanagement.domain.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
@Data
@Entity
@Table(name = "trips")
public class TripModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int tripId;
    int ambulanceId;
    String driverName;
    String tripType;
    LocalDateTime createdDate;

    public TripModel(int ambulanceId, String driverName, String tripType, LocalDateTime createdDate) {
        this.ambulanceId = ambulanceId;
        driverName = driverName;
        this.tripType = tripType;
        this.createdDate = createdDate;
    }

    public TripModel() {

    }
}
