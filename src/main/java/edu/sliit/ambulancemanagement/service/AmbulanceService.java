package edu.sliit.ambulancemanagement.service;

import edu.sliit.ambulancemanagement.domain.dto.AmbulanceDto;
import edu.sliit.ambulancemanagement.domain.http.CommonJsonResponse;

import java.util.List;

public interface AmbulanceService {

    public CommonJsonResponse registerNewAmbulance(AmbulanceDto ambulanceDto);
    public CommonJsonResponse updateAmbulance(AmbulanceDto ambulanceDto);
    public CommonJsonResponse deleteAmbulance(int ambulanceId);
    public CommonJsonResponse viewAllAmbulance();

}
