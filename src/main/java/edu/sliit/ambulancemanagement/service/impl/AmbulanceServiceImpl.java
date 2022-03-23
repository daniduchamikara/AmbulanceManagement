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

import java.util.ArrayList;
import java.util.List;

@Service
public class AmbulanceServiceImpl implements AmbulanceService {

    AmbulanceRepo ambulanceRepo;

    CommonJsonResponse jsonResponse = new CommonJsonResponse();

    public AmbulanceServiceImpl(AmbulanceRepo ambulanceRepo) {
        this.ambulanceRepo = ambulanceRepo;
    }

    @Override
    public CommonJsonResponse registerNewAmbulance(AmbulanceDto ambulanceDto) {
        AmbulanceModel ambulanceModel = new AmbulanceModel();
        ambulanceModel.setVehicleModel(ambulanceDto.getVehicleModel());
        ambulanceModel.setLicensePlate(ambulanceDto.getLicensePlate());
        ambulanceModel.setOther(ambulanceDto.getOther());

        AmbulanceModel response = ambulanceRepo.save(ambulanceModel);
        if (response.getAmbulanceId() > 0) {
            jsonResponse.setStatus(HttpStatus.OK.value());
            jsonResponse.setMessage("Successfully Registered");
        } else {
            jsonResponse.setStatus(HttpStatus.BAD_REQUEST.value());
            jsonResponse.setMessage("Not Successful Please Check Your In puts");
        }
        return jsonResponse;
    }

    @Override
    public CommonJsonResponse updateAmbulance(AmbulanceDto ambulanceDto) {
        AmbulanceModel ambulanceModel = ambulanceRepo.findByAmbulanceId(ambulanceDto.getAmbulanceId());
        ambulanceModel.setAmbulanceId(ambulanceDto.getAmbulanceId());
        ambulanceModel.setVehicleModel(ambulanceDto.getVehicleModel());
        ambulanceModel.setLicensePlate(ambulanceDto.getLicensePlate());
        ambulanceModel.setOther(ambulanceDto.getOther());

        AmbulanceModel response = ambulanceRepo.save(ambulanceModel);
        if (response.getAmbulanceId() > 0) {
            jsonResponse.setStatus(HttpStatus.OK.value());
            jsonResponse.setMessage("Successfully Updated");
        } else {
            jsonResponse.setStatus(HttpStatus.BAD_REQUEST.value());
            jsonResponse.setMessage("Not Successful Please Check Your In puts");
        }
        return jsonResponse;
    }

    @Override
    public CommonJsonResponse deleteAmbulance(AmbulanceDto ambulanceDto) {
        AmbulanceModel ambulanceModel = new AmbulanceModel();
        ambulanceModel.setAmbulanceId(ambulanceDto.getAmbulanceId());
        ambulanceModel.setVehicleModel(ambulanceDto.getVehicleModel());
        ambulanceModel.setLicensePlate(ambulanceDto.getLicensePlate());
        ambulanceModel.setOther(ambulanceDto.getOther());
        ambulanceRepo.delete(ambulanceModel);

        jsonResponse.setStatus(HttpStatus.OK.value());
        jsonResponse.setMessage("Successfully Deleted");

        return jsonResponse;
    }

    @Override
    public List<AmbulanceDto> viewAllAmbulance() {
        List<AmbulanceDto> ambulanceDtoList= new ArrayList<>();
        List<AmbulanceModel> ambulanceModels= ambulanceRepo.findAll();
        for (AmbulanceModel ambulanceModel: ambulanceModels){
            AmbulanceDto ambulanceDto=new AmbulanceDto();
            ambulanceDto.setAmbulanceId(ambulanceModel.getAmbulanceId());
            ambulanceDto.setLicensePlate(ambulanceModel.getLicensePlate());
            ambulanceDto.setVehicleModel(ambulanceModel.getVehicleModel());
            ambulanceDto.setOther(ambulanceModel.getOther());
            ambulanceDtoList.add(ambulanceDto);
        }
        jsonResponse.setStatus(HttpStatus.OK.value());
        jsonResponse.setData(ambulanceDtoList);
        return ambulanceDtoList;
    }
}
