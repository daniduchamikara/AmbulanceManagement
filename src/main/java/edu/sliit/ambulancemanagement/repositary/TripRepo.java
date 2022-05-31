package edu.sliit.ambulancemanagement.repositary;

import edu.sliit.ambulancemanagement.domain.model.TripModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface TripRepo extends JpaRepository<TripModel,Integer> {

    List<TripModel> findByDriverName(String name);
}
