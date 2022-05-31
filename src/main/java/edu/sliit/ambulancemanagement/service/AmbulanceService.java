package edu.sliit.ambulancemanagement.service;

import edu.sliit.ambulancemanagement.domain.dto.AmbulanceDto;
import edu.sliit.ambulancemanagement.domain.http.CommonJsonResponse;

import java.util.List;

public interface AmbulanceService {

    public CommonJsonResponse registerNewAmbulance(AmbulanceDto ambulanceDto);
    public CommonJsonResponse updateAmbulance(AmbulanceDto ambulanceDto);
    public CommonJsonResponse updateAmbulanceStatus(String id, String key,String driverName,String tripType);
    public CommonJsonResponse deleteAmbulance(AmbulanceDto ambulanceDto);
    public List<AmbulanceDto> viewAllAmbulance();

}
