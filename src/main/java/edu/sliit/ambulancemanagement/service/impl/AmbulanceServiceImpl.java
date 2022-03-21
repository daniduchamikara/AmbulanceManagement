package edu.sliit.ambulancemanagement.service.impl;

import edu.sliit.ambulancemanagement.domain.dto.AmbulanceDto;
import edu.sliit.ambulancemanagement.domain.http.CommonJsonResponse;
import edu.sliit.ambulancemanagement.domain.model.AmbulanceModel;
import edu.sliit.ambulancemanagement.repositary.AmbulanceRepo;
import edu.sliit.ambulancemanagement.service.AmbulanceService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AmbulanceServiceImpl implements AmbulanceService {

    AmbulanceRepo ambulanceRepo;

    CommonJsonResponse jsonResponse=new CommonJsonResponse();

    public AmbulanceServiceImpl(AmbulanceRepo ambulanceRepo) {
        this.ambulanceRepo = ambulanceRepo;
    }

    @Override
    public CommonJsonResponse registerNewAmbulance(AmbulanceDto ambulanceDto) {
        AmbulanceModel ambulanceModel=new AmbulanceModel();
        ambulanceModel.setVehicleModel(ambulanceDto.getVehicleModel());
        ambulanceModel.setLicensePlate(ambulanceDto.getLicensePlate());
        ambulanceModel.setOther(ambulanceDto.getOther());

        AmbulanceModel response=ambulanceRepo.save(ambulanceModel);
        if (response.getAmbulanceId()>0){
            jsonResponse.setStatus(HttpStatus.OK.value());
            jsonResponse.setMessage("Successfully Registered");
        }else{
            jsonResponse.setStatus(HttpStatus.BAD_REQUEST.value());
            jsonResponse.setMessage("Not Successful Please Check Your In puts");
        }
        return null;
    }

    @Override
    public CommonJsonResponse updateAmbulance(AmbulanceDto ambulanceDto) {
        return null;
    }

    @Override
    public CommonJsonResponse deleteAmbulance(int ambulanceId) {
        return null;
    }

    @Override
    public CommonJsonResponse viewAllAmbulance() {
        return null;
    }
}
