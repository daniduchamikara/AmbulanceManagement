package edu.sliit.ambulancemanagement.repositary;

import edu.sliit.ambulancemanagement.domain.model.AmbulanceModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AmbulanceRepo extends JpaRepository<AmbulanceModel,Integer> {
    AmbulanceModel findByAmbulanceId(int ambulanceId);
}
