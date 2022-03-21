package edu.sliit.ambulancemanagement.domain.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "ambulance")
public class AmbulanceModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int ambulanceId;
    String licensePlate;
    String vehicleModel;
    String other;

}
