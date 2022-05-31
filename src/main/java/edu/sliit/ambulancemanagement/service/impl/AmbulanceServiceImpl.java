package edu.sliit.ambulancemanagement.service.impl;

import edu.sliit.ambulancemanagement.constant.CommonConstant;
import edu.sliit.ambulancemanagement.domain.dto.AmbulanceDto;
import edu.sliit.ambulancemanagement.domain.http.CommonJsonResponse;
import edu.sliit.ambulancemanagement.domain.model.AmbulanceModel;
import edu.sliit.ambulancemanagement.domain.model.TripModel;
import edu.sliit.ambulancemanagement.repositary.AmbulanceRepo;
import edu.sliit.ambulancemanagement.repositary.TripRepo;
import edu.sliit.ambulancemanagement.service.AmbulanceService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class AmbulanceServiceImpl implements AmbulanceService {

    AmbulanceRepo ambulanceRepo;
    TripRepo tripRepo;

    CommonJsonResponse jsonResponse = new CommonJsonResponse();

    public AmbulanceServiceImpl(AmbulanceRepo ambulanceRepo, TripRepo tripRepo) {
        this.ambulanceRepo = ambulanceRepo;
        this.tripRepo = tripRepo;
    }

    @Override
    public CommonJsonResponse registerNewAmbulance(AmbulanceDto ambulanceDto) {
        AmbulanceModel ambulanceModel = new AmbulanceModel();
        ambulanceModel.setVehicleModel(ambulanceDto.getVehicleModel());
        ambulanceModel.setLicensePlate(ambulanceDto.getLicensePlate());
        ambulanceModel.setOther(ambulanceDto.getOther());
        ambulanceModel.setStatus(CommonConstant.AVAILABLE.toString());

        AmbulanceModel response = ambulancePersist(ambulanceModel);
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
        ambulanceModel.setStatus(ambulanceDto.getStatus());

        AmbulanceModel response = ambulancePersist(ambulanceModel);
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
    public CommonJsonResponse updateAmbulanceStatus(String recordid, String key,String driverName,String tripType) {
        TripModel tripModelRes = null;

        Integer id= Integer.valueOf(recordid);
        AmbulanceModel ambulanceModel = ambulanceRepo.findByAmbulanceId(id);
        if (key.equals(CommonConstant.AVAILABLE.toString())){
            ambulanceModel.setStatus(CommonConstant.AVAILABLE.toString());
        }else if (key.equals(CommonConstant.ON_DUTY.toString())){
            ambulanceModel.setStatus(CommonConstant.ON_DUTY.toString());
        }else if (key.equals(CommonConstant.NOT_AVAILABLE.toString())){
            ambulanceModel.setStatus(CommonConstant.NOT_AVAILABLE.toString());
        }
        if (key.equals(CommonConstant.ON_DUTY.toString())) {
            LocalDateTime dateAndTime = LocalDateTime.now().now();
            TripModel tripModel = new TripModel(Integer.valueOf(recordid), driverName, tripType, dateAndTime);
            tripModelRes = tripRepo.save(tripModel);
        }

        AmbulanceModel response = ambulancePersist(ambulanceModel);
        if (response.getAmbulanceId() > 0 ) {
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
        List<AmbulanceDto> ambulanceDtoList = new ArrayList<>();
        List<AmbulanceModel> ambulanceModels = ambulanceRepo.findAll();
        for (AmbulanceModel ambulanceModel : ambulanceModels) {
            AmbulanceDto ambulanceDto = new AmbulanceDto();
            ambulanceDto.setAmbulanceId(ambulanceModel.getAmbulanceId());
            ambulanceDto.setLicensePlate(ambulanceModel.getLicensePlate());
            ambulanceDto.setVehicleModel(ambulanceModel.getVehicleModel());
            ambulanceDto.setOther(ambulanceModel.getOther());
            ambulanceDto.setStatus(ambulanceModel.getStatus());
            ambulanceDtoList.add(ambulanceDto);
        }
        jsonResponse.setStatus(HttpStatus.OK.value());
        jsonResponse.setData(ambulanceDtoList);
        return ambulanceDtoList;
    }

    AmbulanceModel ambulancePersist(AmbulanceModel ambulanceModel) {
        return ambulanceRepo.save(ambulanceModel);
    }
}
