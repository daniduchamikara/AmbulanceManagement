package edu.sliit.ambulancemanagement.repositary;

import edu.sliit.ambulancemanagement.domain.model.AmbulanceModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AmbulanceRepo extends JpaRepository<AmbulanceModel,Integer> {
}
